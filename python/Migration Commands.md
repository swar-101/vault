

`python manage.py makemigrations`

- What it does: 
	Create migration files based on the changes you've made to your models (in `model.py`)
- Think of it like: 
	"Git add" for your database. It's like staging your changes.
- Output: 
	A new Python file inside your app's `migrations/` folder (e.g., `0001_initial.py`)

`python manage.py migrate`

- What it does: 
	Actually applies those migration files to your real databases (SQLite, PostgreSQL)
- Think of it like: 
	"Git commit" for your database. You're applying the changes and making them real.


