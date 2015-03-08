import java.util.List;
import java.util.ObservableCollection;


public class Person implements INotifyPropertyChanged{
	private String _name;
	private int _age;
	private List<Person> _children = new ObservableCollection<Person>();
	
	public Person(String name, int age){
		this._name =name;
		this._age = age;
	}
	public String name{
		&{
			return this._name;
		}
		+{
			String oldValue = this._name;
			this._name = value;
			if(oldValue != value){
				notify(this, new PropertyChangeEvent("name"));
			}
		}
	}
	

	public int age{
		&{
			return this._age;
		}
		+{
			int oldValue = this._age;
			this._age = value;
			if(oldValue != value){
				notify(this, new PropertyChangeEvent("age"));
			}
		}
	}
	
	public List<Person> children{
		&{
			return this._children;
		}
		+{
			List<Person> oldValue = this._children;
			this._children = value;
			if(oldValue != value){
				notify(this, new PropertyChangeEvent("children"));
			}
		}
	}
	
	public boolean _selected;
	public boolean selected{
		&{
			return this._selected;
		}
		+{
			boolean oldValue = this._selected;
			this._selected = value;
			if(oldValue != value){
				notify(this, new PropertyChangeEvent("selected"));
			}
		}
	}
	
	protected void notify(Object source, PropertyChangeEvent event){
		PropertyChange[] handlers = (PropertyChange[])listeners[event.propertyName];
		if(handlers != undefined){
			handlers.forEach((PropertyChange value, int index, Array<PropertyChange> array)->{
				value(source, event);
			});
		}
	}  

	private Object listeners= new Object();

	public void addPropertyChangeListener(String propName, PropertyChange handler) {
		PropertyChange[] handlers = (PropertyChange[])listeners[propName];
		if(handlers == undefined){
			handlers = new Array<PropertyChange>();
			listeners[propName] = handlers;
		}
		handlers.push(handler);
	}

	public void removePropertyChangeListener(String propName, PropertyChange handler) {
		PropertyChange[] handlers = (PropertyChange[])listeners[propName];
		if(handlers != undefined){
			handlers.forEach((PropertyChange value, int index, Array<PropertyChange> array)->{
				if(value === handler){
					handlers.splice(index, 1);
				}
			});
		}
	}
}
