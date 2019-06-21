

Run the application and run following GET URL for example

localhost:8080/getData?customerType=FreeLancer

This will work and enum mapping will work fine, otherwise by default spring support enum names in request.

For example, In above case you needed to pass freelancer in capital case as defined in enum.


CustomConverter here extends PropertyEditorSupport class and overrides `setAsText` method

Then register the converter for enum using `registerCustomEditor` as below

```
@InitBinder
	public void initBinder(final WebDataBinder webdataBinder) {
		webdataBinder.registerCustomEditor(Customer.class, new CustomerConverter());
	}
	
```