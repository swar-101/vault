**Requirements:** 
1. We will have multiple cities. 
2. Each city has mulitple theatres. 
3. Each theatre has multiple screens. 
4. Each screen has multiple seats. 
5. There are different types of seats: PLATINUM, GOLD, SILVER. 
6. Each screen will have multiple shows. 
7. Every show will be for a movie and will have a start time and end time. 
8. Each show depending upon the day, time and seat type will have different prices. 
9. Movies, shows and screens will support features like 2D, 3D, DOLBY_IMAX, DOLBY_VISION etc.
10. We integrate with Razorpay to handle payments. 
11. Users should be able to book multiple seats for a show via the app by paying for them at the time of booking.

## Solution

Entities:

1. City
2. Theater
3. Screen
4. Seat
5. SeatType
6. Show
7. Movie
8. ShowTiming
9. Pricing
10. Feature
11. Payment
12. RazorPayPayment
13. Booking
14. User
15. Invoice
16. Ticket


Relationships: 
1. A `Theater` will have multiple `Screen`.
2. Many `Theater` will be in many cities.
3. A `Screen` can have multiple `Show`.
4. A `Screen` has multiple `Seat`.
5. A `Seat` will have  `SeatType`: PLATINUM, SILVER, GOLD.
6. A `Show` has a `Movie`
7. A `Show` has `ShowPricing` depending on day, time and `SeatType`
8. A `Movie`, `Screen`, `Show` will have a `Feature`: 2D, 3D, DOLBY_IMAX, DOLBY_VISION.
9. A `Payment` will have `PaymentMode`: CASH, CARD, RAZORPAY, UPI.
10. A `Payment` will have `PaymentStrategy` according to `PaymentMode`.
11. A  `User` can book one or more `Seat` for `Show`.
12. A `User` will have zero to many `Booking`.

Class Diagram Script:

```java
@startuml

	abstract class BaseModel {
		- id: long
		- createdAt: LocalDateTime
		- updatedAt: LocalDateTime
	}
	
	class Address extends BaseModel {
		- line1: String
		- line2: String
		- city: String
		- state: String
		- zipCode: String
		- country: String
	} 
	
	class Theater extends BaseModel {
		- name: String
		- address: Address
	}
	
	theater --> address
	
	enum Feature {
		TWO_D, THREE_D, DOLBY_IMAX, DOLBY_VISION
	}
	
	enum SeatType {
		SILVER, GOLD, PLATINUM
	}
	
	class Seat extends BaseModel {
		- type : SeatType
		- number: int
		- row: char
	}
	
	seat --> seatType
	
	class Screen extends BaseModel {
		- name: String
		- feature: Feature
		- seats: List<Seat>
	}
	
	screen *-- seat
	screen --> feature
	
	class ShowPricing extends BaseModel {
		- seatType: SeatType
		- price: int
	}
	
	class Show extends BaseModel {
		- screen: Screen
		- movie: Movie
		- startTime: LocalDateTime
		- endTime: LocalDateTime
		- feature: Feature
		- showPricing: ShowPricing
	}
	
	show --> feature
	show --> screen
	show --> movie
	show --> showPricing
	
	enum Language {
		ENGLISH, HINDI, MARATHI, TAMIL, TELUGU, SPANISH
	}
	
	class Movie extends BaseModel {
		- name: String
		- feature: Feature
		- language: Language
		- durationInMinutes: int 
	}
	
	movie --> feature
	movie --> language
	
	
	class User extends BaseModel {
		- name: String
		- email: String
		- address: Address
	}
	
	user --> address
	
	class Booking extends BaseModel {
		- user: User
		- show: Show
		- seats: List<Seat>
	}
	
	booking --> user
	booking --> show
	booking *-- seat
	
	class Ticket extends BaseModel {
		- user: User
		- booking: Booking
		- screen: Screen
	}
	
	ticket --> user
	ticket --> booking
	ticket --> screen
	
	enum PaymentStatus {
		PAID, PENDING, FAILED
	}
	
	enum PaymentMode {
		CASH, CARD, UPI, RAZORPAY
	}
	
	interface PaymentStrategy {
		~ pay(booking: Booking)
	}
	
	class Payment extends BaseModel {
		- ticket: Ticket
		- status: PaymentStatus
		- mode: PaymentMode
		+ setStrategy(strategy: PaymentStrategy)
	}
	
	payment --> ticket
	payment --> status
	payment --> mode
	
	class RazorpayPaymentStrategy implements PaymentStrategy {
		- pay(booking: Booking)
	}
	
	class Invoice {
		- user: User
		- totalAmount: int
		- payment: Payment
	}
	
	invoice --> user
	invoice --> payment

@enduml
```
