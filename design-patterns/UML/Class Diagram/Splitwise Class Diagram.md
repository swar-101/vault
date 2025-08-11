Requirements:

1. Users should be able to track their expense with other users.
2. Users should be able to create groups and start tracking expenses.
3. Multiple people can pay up in an expense. Also, amount can be split up unequally in an expense. Consider this example: Users involved A,B,C Expense amount: 2000 A B C Paid amount: 1500 500 0 Owed amount: 500 500 1000 Here A paid 1500 and B paid 500. But A and B consumed worth 500 where as C consumed worth 1000.
4. Users should be able to able to settle up their balances with minimum number of transactions using the settle up feature.

---

## Solution

Classes: 
1. `User`
2. `Group`
3. `Expense`
4. `Trasaction`
5. `BalanceSheet`
6. `UserGroupService: createGroup(userId, List<Long> userIds) : Group`
7. `ExpenseSettlementService`: `settleExpense(List<Long> userIds) : List<Transaction>`



Class Diagram: 

```java
abstract class BaseModel {
	-id: long
	-createdAt: LocalDateTime
	-updatedAt: LocalDateTime
}

class User extends BaseModel {
	-name: String
	-phone: String
	-email: String 
}

class Group extends BaseModel {
	-admin: User
	-members: List<User>
	-createdBy: User
}

enum UserRole {
	ADMIN, MEMBER
}

class GroupUser extends BaseModel {
	-userRole: UserRole
	-group: Group
	-user: User
}

class Balance {
	-fromUser: User
	-toUser: User
	-amount: double
}

class Transaction {
	-fromUser: User
	-toUser: User
	-amount: double
}

class BalanceSheet extends BaseModel {
	-user: User
	-paidAmount: double
	-owedAmount: double
}

class ExpenseSplit extends BaseModel {
	-user: User
	-expense: Expense
	-paidAmount: double
	-owedAmount: double
}

class Expense extends BaseModel {
	-description: String
	-totalAmount: double
	-splits: List<ExpenseSplit> 
}

class ExpenseService {
	+List<Transaction> settleUp(userIds: List<Long>);
	+List<Transaction> settleUp(group: Group)
}

class GroupService {
	+createGroup(adminId: long, userIds: List<Long>)
	+addUser(adminId: long, userId: long): void
	+getGroupMembers(groupId: long): List<User>
}
```