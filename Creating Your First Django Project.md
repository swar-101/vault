
0. [[Install Python]]


## Step 2: Set Up The Django Project


```
python -m venv venv
```

```
venv\Sripts\activate
```

```
pip install django djangorestframework
```

```
django-admin startproject myapi
```

```
cd myapi
```


3. Open the project using your favourite IDE. I prefer PyCharm. Use the following command to open the project in the root folder.
	
```
pycharm . 
```

// INCLUDE OTHER IDEs //


## Step 3: Settings & Config

In `myapi/settings.py`:

```python

INSTALLED_APPS = [
	

]
```