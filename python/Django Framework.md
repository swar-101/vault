


## [[Creating Your First Django Project]]

## render() VS redirect() VS HttpResponse()

- `render()` returns HTML template with context. 
- `redirect()` send user to a different URL. 
- `HttpResonse()` raw text or custom response (useful for APIs or debugging).


## [[Migration Commands]]


## QuerySet

- A lazy, iterable object representing DB queries.
- Supports filters, chaining, slicing, etc. 

 
## MTV Architecture 


1. Model: DB structure and logic (e.g. User, Product)
2. Template: Presentation layer (HTML, Data Rendering)
3. View: Business logic; connects Model And Template 


### Model



### Template

### View 


 
### asgi.py and wsgi.py files

asgi and wsgi files are used when we deploy our Django project to a web server like Nginx.

