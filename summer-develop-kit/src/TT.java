import java.util.List;


interface T{
	default void test(int i){
		
	}
}

interface T1{
	default void test1(int i){
		
	}
}

class SS{
	public void test1(int i){
//		super.test1();	
	}
	
	public void test(int i){
		int m = (int) Math.max(10,10,10);
	}
	
	private String _name;
	public String name {
		&{
			return this._name;
		}
		+{
			if(this._name === value){
				return;
			}
			this._name = value;
			propertyChanged("name");
		}
	}
	
	private Object _listeners = new Object();
	protected void propertyChanged(String propName){
		PropertyChangeEvent event = new PropertyChangeEvent(propName);
		PropertyChange[] listeners = (PropertyChange[])_listeners[propName];
		if(listeners == null){
			return;
		}
		listeners.forEach((PropertyChange h, int index, Array<PropertyChange> array)->{
			h(this, event);
		});
	}
	public void addPropertyChangeListener(String propName, PropertyChange handler){
		PropertyChange[] listeners = (PropertyChange[])_listeners[propName];
		if(listeners == null){
			listeners = new Array<PropertyChange>();
			_listeners[propName] = listeners;
		}
		listeners.push(handler);
	}
	
	public void removePropertyChangeListener(String propName, PropertyChange handler){
		PropertyChange[] listeners = (PropertyChange[])_listeners[propName];
		if(listeners == null){
			return;
		}
		listeners.forEach((PropertyChange h, int index, Array<PropertyChange> array)->{
			if(handler === h){
				listeners.splice(index, 1);
			}
		});
	}
}

class TT extends SS implements T, T1{
//	public void test1(int i){
//	}
//	
//	public void test(int i){
//		
//	}
}

class Test111{
	void dd(){
		TT t = new TT();
		t.test1(10);
	}
	
    public void rebox(List<?> box) {
        reboxHelper(box);
    }

    private void reboxHelper<V>(List<V> box) {
//        box[0] = box[0];
    	box.add(box.get(0));
    }
}
