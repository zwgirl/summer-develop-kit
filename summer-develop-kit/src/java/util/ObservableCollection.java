@Module
package java.util;

import java.util.List;

public class ObservableCollection<T> extends ArrayList<T> implements List<T> ,INotifyCollectionChanged<T>, INotifyPropertyChanged { 
	private static final long serialVersionUID = 1L;

	public static final String SIZE = "size";
    
    private transient Object propertyChangeListeners = new Object(); // Map<String, Array<PropertyChange>>

    // Occurs when the collection changes, either by adding or removing an item.
    private transient CollectionChanged<T>[] collectionChangedListeners = new Array<CollectionChanged<T>>(); // Map<String, Array<CollectionChanged>>; 
    
    public ObservableCollection()  { super(); } 

    public ObservableCollection(List<T> list) {
        copyFrom(list);
    }

    public ObservableCollection(Iterable<T> collection) {
        if (collection == null) 
            throw new Error(0, "collection may not be null!");

        copyFrom(collection);
    } 

    private void copyFrom(Iterable<T> collection) { 
        if (collection != null) {
            Iterator<T> enumerator = collection.iterator();
            while (enumerator.hasNext()) {
                this.add(enumerator.next()); 
            } 
        } 
    }

    // Move item at oldIndex to newIndex. 
    public void move(int oldIndex, int newIndex) { 
        moveItem(oldIndex, newIndex);
    }

    // Called by base class Collection&lt;T&gt; when the list is being cleared;
    // raises a CollectionChanged event to any listeners. 
    public void clear() { 
        super.clear(); 
        onPropertyChanged(this, new PropertyChangeEvent(SIZE));
        onCollectionReset();
    } 

    // Called by base class Collection&lt;T&gt; when an item is removed from list; 
    // raises a CollectionChanged event to any listeners.
    public T removeAt(int index) {
        T removedItem  = this.get(index); 

        super.removeAt(index); 

        onPropertyChanged(this, new PropertyChangeEvent(SIZE));
        onCollectionChanged(CollectionChangedAction.Remove, removedItem, index);
		return removedItem;
    }
    
    public boolean remove(Object o){
		return false;
    }
    
    public boolean add(T t){
		return false;
    	
    }

    // Called by base class Collection&lt;T&gt; when an item is added to list;
    // raises a CollectionChanged event to any listeners. 
    public void addAt(int index, T item){ 
        super.addAt(index, item);

        onPropertyChanged(this, new PropertyChangeEvent(SIZE)); 
        onCollectionChanged(CollectionChangedAction.Add, item, index); 
    } 

    // Called by base class Collection&lt;T&gt; when an item is set in list;
    // raises a CollectionChanged event to any listeners.
    public T set(int index, T item) {
        T originalItem = this.get(index); 
        super.set(index, item);

        onPropertyChanged(this, new PropertyChangeEvent(SIZE));
        onCollectionChanged(CollectionChangedAction.Replace, originalItem, item, index);
		return originalItem;
    }

    // Called by base class ObservableCollection&lt;T&gt; when an item is to be moved within the list; 
    // raises a CollectionChanged event to any listeners. 
    protected void moveItem(int oldIndex, int newIndex){
        T removedItem = super.removeAt(oldIndex); 
        super.addAt(newIndex, removedItem);  

        onCollectionChanged(CollectionChangedAction.Move, removedItem, newIndex, oldIndex);
    }

    // Raises a PropertyChanged event (per <see cref="INotifyPropertyChanged" />). 
    protected void onPropertyChanged(Object source, PropertyChangeEvent e) { 
        if (this.propertyChangeListeners != null) {
        	PropertyChange[] propertyChanges = (PropertyChange[])this.propertyChangeListeners[e.propertyName];
        	propertyChanges.forEach((PropertyChange callback, int index, Array<PropertyChange> array)->{
        		callback(source, e);
        	});
        } 
    }

    // Raise CollectionChanged event to any listeners.
    // Properties/methods modifying this ObservableCollection will raise 
    // a collection changed event through this method. 
    // When overriding this method, either call its base implementation
    // or call <see cref="BlockReentrancy"/> to guard against reentrant collection changes.
    protected void onCollectionChanged(CollectionChangedEvent<T> e) {
    	this.collectionChangedListeners.forEach((CollectionChanged<T> callback, int index, Array<CollectionChanged<T>> array)->{
    		callback(e);
    	});
    } 

    // Helper to raise CollectionChanged event to any listeners 
    private void onCollectionChanged(CollectionChangedAction action, T item, int index) { 
        onCollectionChanged(new CollectionChangedEvent<T>(action, item, index));
    }

    // Helper to raise CollectionChanged event to any listeners
    private void onCollectionChanged(CollectionChangedAction action, T item, int index, int oldIndex) {
        onCollectionChanged(new CollectionChangedEvent<T>(action, item, index, oldIndex)); 
    }

    // Helper to raise CollectionChanged event to any listeners 
    private void onCollectionChanged(CollectionChangedAction action, T oldItem, T newItem, int index) { 
        onCollectionChanged(new CollectionChangedEvent<T>(action, newItem, oldItem, index));
    } 

    // Helper to raise CollectionChanged event with action == Reset to any listeners
    private void onCollectionReset() { 
        onCollectionChanged(new CollectionChangedEvent<T>(CollectionChangedAction.Reset)); 
    }
    
	public void addPropertyChangeListener(String propName, PropertyChange handler) {
		PropertyChange[] listeners = (PropertyChange[])this.propertyChangeListeners[propName];
		if(listeners == null){
			listeners = new Array<PropertyChange>();
		}
		
		listeners.push(handler);
	}

	public void removePropertyChangeListener(String propName, PropertyChange handler) {
		PropertyChange[] listeners = (PropertyChange[])this.propertyChangeListeners[propName];
		if(listeners == null){
			listeners = new Array<PropertyChange>();
		}
		
		listeners.forEach((PropertyChange handler1, int index, Array<PropertyChange> array)->{
			if(handler1 === handler){
				array.splice(index, 1);
			}
		});
	}

	public void addCollectionChangedListener(CollectionChanged<T> listener) {
		collectionChangedListeners.push(listener);
		
	}

	public void removeCollectionChangedListener(CollectionChanged<T> listener) {
		collectionChangedListeners.forEach((CollectionChanged<T> listener1, int index, Array<CollectionChanged<T>> array)->{
			if(listener1 === listener){
				array.splice(index, 1);
			}
		});
	}
}
