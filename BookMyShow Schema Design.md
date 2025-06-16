Requirements:

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
1. Theater
2. Screen
3. Seat
4. SeatType (enum: PLATINUM, GOLD, SILVER)
5. Show
6. ShowPricing 
7. Payment
8. Booking 
9. Ticket
10. Invoice


Schema: 

table: `address`
fields: 
- id (PK)
- line1
- line2
- city
- state
- zipcode
- country

table: `theater`
fields: 
- id (PK)
- address_id (FK)
- name


table: `seat`
fields: 
- id (PK)
- type (enum: SILVER, GOLD, PLATINUM)
- number 
- row 

table: `screen`
fields: 
- id (PK)
- name 
- feature (enum: TWO_D, THREE_D, DOLBY_IMAX, DOLBY_VISION)

table: `screen_seat`
fields: 
- id (PK)
- screen_id (FK)
- seat_id (FK)

table: `show`
fields: 
- id (PK)
- screen_id (FK)
- movie_id (FK)
- show_pricing_id (FK)
- start_time 
- end_time

table: `show_pricing`
fields: 
- id (PK)
- show_id (FK)
- seat_type (enum: SILVER, GOLD, PLATINUM)
- price

table: `show_seat`
fields: 
- id (PK)
- show_id (FK)
- seat_id (FK)

table: `movie`
fields: 
- id (PK)
- name
- feature (enum: TWO_D, THREE_D, DOLBY_IMAX, DOLBY_VISION)
- language (enum: ENGLISH, HINDI, MARATHI, TAMIL, TELUGU, SPANISH)
- duration_in_minutes

table: `user`
fields: 
- id (PK)
- address_id (FK)
- name
- email
- phone_number

table: `booking`
fields: 
- id (PK)
- user_id (FK)
- show_steat_id (FK)

table: `ticket`
fields: 
- id (PK)
- user_id (FK)
- booking_id (FK)

table: `ticket_seat`
fields: 
- id (PK)
- seat_id (FK)
- ticket_id (FK)

table: `payment`
fields:
- id (PK)
- mode (enum: CASH, CARD, UPI, RAZORPAY)
- status (enum: SUCCESS, PENDING, FAILED)
- external_id 
- txn_id
- ticket_id (FK)

table: `invoice`
fields: 
- id (PK)
- total_amount
- payment_id (FK)
- booking_id (FK)

