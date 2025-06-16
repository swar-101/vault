  
Requirements:

1. Parking lot will have multiple floors.
    
2. There will be multiple entry and exit gates.
    
3. Parking lot will support parking for these vehicles: CAR, BIKE, TRUCK. We should park only appropriate vehicle at their spots i.e. a spot for CAR cannot be used to park bikes.
    
4. When a user enters via an entry gate, the operator generates a ticket and gives it to the user. The ticket contains information like entry time, vehicle number, assigned parking spot. Parking spots should be assigned as per the nearest available spot first i.e. find the nearest appropriate spot for a vehicle and assign it. This way of assigning spot may change in the future.
    
5. Once the user decides to exit the parking lot, they will handover the ticket to the operator at the exit gate upon which their final bill will be calculated.
    
6. Bill calculation for a vehicle depends upon to two things, time spent in the parking lot and the type of vehicle. Refer the below tables to understand pricing. For BIKEs: Hours spent Price per hour 0-2 20 2-4 25 4-6 30 6 onwards 40
    
    For CARs: Hours spent Price per hour 0-2 25 2-4 30 4-6 35 6 onwards 45
    
    For TRUCKs: Hours spent Price per hour 0-2 50 2-4 60 4-6 65 6 onwards 80
    
    For eg. If a car spends 5.5 hours in the parking lot then their final bill will be: 2 * 25 (Charge for first 2 hours) + 2 * 30 (Charge for the next two hours i.e hour 3 and hour 4) + 2 * 35 (Charge for 5th hour and 6th hour (Note: even tough the vehicle was not in the parking lot for the entire hour, we charged it for the entire hour)) = Rs. 180 Note: This is one way of charging customers, in the future we might change this.
    
7. We will integrate with Razorpay to manage payments.

---
### Solution : 

Entities: 

1. parking_lot
2. floor
3. gate
4. vehicle
5. user
6. operator
7. ticket
8. bill
9. spot
10. payment


Relationships: 

1. a `parking_lot` has many `floor`.
2. a `floor` has many `spot`.
3. a `floor` has at least two `gate`.
4. a `user` has many `ticket`.
5. a `user` has many `vehicle`.
6. a `gate` has at least one `operator`.
7. a `ticket` has one `bill`.
8. a `vehicle` has one `spot`.
9. a `user` has many `payment`.
10. a `user` has many `bill`.


table: `address`
fields: 
	- id (PK)
	- line_1
	- line_2
	- street
	- city
	- zipcode
	- country

table: `parking_lot`
fields: 
	- id (PK)
	- name 
	- address_id (FK)

table: `floor`
fields: 
	- id (PK)
	- parking_lot_id (FK)
	- floor_level 

table: `spot`
fields: 
	- id (PK)
	- floor_id (FK)
	- type (enum: CAR, BIKE, TRUCK)
	- status (enum: OCCUPIED, VACANT, OUT_OF_ORDER)

table: `user`
fields: 
	- id (PK)
	- name
	- email
	- phone_number
	- status (enum: ENGAGED, UNENGAGED)
	- address_id (FK)

table: `vehicle`
fields: 
	- id (PK)
	- type (enum: CAR, BIKE, TRUCK)
	- user_id (FK)
	
	
table : `operator`
fields: 
	- id (PK)
	- name 
	- email
	- status 
	- phone_number
	- address_id (FK)

table : `gate`
fields:
	- id (PK)
	- operator_id (FK)
	- floor_id (FK)
	- status (enum: OPEN, CLOSE, OUT_OF_ORDER)
	- type (enum: ENTRY, EXIT, UNASSIGNED)

table : `gate_operator`
fields: 
	- id (PK)
	- operator_id (FK)
	- gate_id (FK)

table: `ticket`
fields: 
	- id (PK)
	- user_id (FK)
	- vehicle_id (FK)
	- spot_id (FK)
	- entry_operator_id (FK)
	- exit_operator_id (FK)
	- entry_time 
	- exit_time
	- created_at
	- updated_at


table: `bill`
fields: 
	- id (PK)
	- ticket_id (FK)
	- total_amount
	- billed_duration
	- actual_duration
	- created_at
	- updated_at


table: `payment`
fields: 
	- id (PK)
	- ticket_id (FK)
	- bill_id (FK)
	- txn_id
	- type (enum: RAZORPAY, PAYTM, UPI, CASH, CARD)
	- gateway_payment_id
	- status (enum: PAID, PENDING, FAILED)

table: `pricing`
fields: 
	- id (PK)
	- vehicle_type (enum: CAR, BIKE, TRUCK)
	- start_hour
	- end_hour
	- rate
	- effective_from
	- is_active (boolean)