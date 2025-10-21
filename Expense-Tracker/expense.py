import os

EXPENSE_FILE = "expenses.txt"

def load_expenses():
    if not os.path.exists(EXPENSE_FILE):
        return []
    with open(EXPENSE_FILE, "r") as file:
        return [line.strip() for line in file.readlines()]

def save_expenses(expenses):
    with open(EXPENSE_FILE, "w") as file:
        for expense in expenses:
            file.write(expense + "\n")

def add_expense(expenses):
    item = input("Enter expense item: ").strip()
    amount = input("Enter amount: ").strip()
    category = input("Enter category (food, travel, etc.): ").strip()
    entry = f"{item} - ₹{amount} [{category}]"
    expenses.append(entry)
    save_expenses(expenses)
    print(f" Added: {entry}")

def view_expenses(expenses):
    if not expenses:
        print("📭 No expenses recorded.")
    else:
        print("\n Expense History:")
        for i, expense in enumerate(expenses, 1):
            print(f"{i}. {expense}")

def main():
    expenses = load_expenses()
    while True:
        print("\n Expense Tracker Menu:")
        print("1. View expenses")
        print("2. Add expense")
        print("3. Exit")
        choice = input("Choose an option (1-3): ").strip()

        if choice == "1":
            view_expenses(expenses)
        elif choice == "2":
            add_expense(expenses)
        elif choice == "3":
            print("Stay financially wise!")
            break
        else:
            print(" Invalid choice. Try again.")

if __name__ == "__main__":
    main()
