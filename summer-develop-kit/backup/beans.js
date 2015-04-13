(function(){ 
  function PropertyChangeListener(){};
  __cache["java.lang.PropertyChangeListener"] = PropertyChangeListener;
  PropertyChangeListener.prototype.__class = new (__lc('java.lang.Class'))("java.lang.PropertyChangeListener", PropertyChangeListener, Object.prototype.__class, [], 2);
  return  PropertyChangeListener;
})();
(function(){ 
  function INotifyPropertyChanged(){};
  __cache["java.lang.INotifyPropertyChanged"] = INotifyPropertyChanged;
  INotifyPropertyChanged.prototype.notifyChanged = function(property){
    var event = new (__lc('java.lang.PropertyChangeEvent'))(property);
    var _listeners = this["__listeners"];
    if(_listeners != null)
    {
      _listeners.forEach((function(h, index, array){
        h(this, event);
      }).bind(this));
    }
    var _propListeners = this["__propListeners"];
    if(_propListeners != null)
    {
      _listeners = _propListeners.get(property);
      if(_listeners != null)
      {
        _listeners.forEach((function(h, index, array){
          h(this, event);
        }).bind(this));
      }
    }
    var _pListeners = this["__pListeners"];
    if(_pListeners != null)
    {
      _pListeners.forEach((function(pp, index, array){
        var pd = pp[0];
        if(pd(this, property))
        {
          var pc = pp[1];
          pc(this, event);
        }
      }).bind(this));
    }
  };
  INotifyPropertyChanged.prototype.addPropertyChangeListener1 = function(handler){
    var _listeners = this["__listeners"];
    if(_listeners == null)
    {
      this["__listeners"] = _listeners = new Array();
    }
    _listeners.push(handler);
  };
  INotifyPropertyChanged.prototype.removePropertyChangeListener1 = function(handler){
    var _listeners = this["__listeners"];
    if(_listeners == null)
    {
      return;
    }
    _listeners.forEach((function(h, index, array){
      if(handler === h)
      {
        _listeners.splice(index, 1);
        return;
      }
    }).bind(this));
  };
  INotifyPropertyChanged.prototype.addPropertyChangeListener = function(propName, handler){
    var _propertyListeners = this["__propListeners"];
    if(_propertyListeners == null)
    {
      this["__propListeners"] = _propertyListeners = new Map();
    }
    var listeners = _propertyListeners.get(propName);
    if(listeners == null)
    {
      listeners = new Array();
      _propertyListeners.set(propName, listeners);
    }
    listeners.push(handler);
  };
  INotifyPropertyChanged.prototype.removePropertyChangeListener = function(propName, handler){
    var _propertyListeners = this["__propListeners"];
    if(_propertyListeners == null)
    {
      return;
    }
    var listeners = _propertyListeners.get(propName);
    if(listeners == null)
    {
      return;
    }
    listeners.forEach((function(h, index, array){
      if(handler === h)
      {
        listeners.splice(index, 1);
        if(listeners.length == 0)
        {
          _propertyListeners.delete(propName);
        }
        return;
      }
    }).bind(this));
  };
  INotifyPropertyChanged.prototype.addPropertyChangeListener3 = function(predicate, handler){
    var _listeners = this["__pListeners"];
    if(_listeners == null)
    {
      this["__pListeners"] = _listeners = new Array();
    }
    _listeners.push([predicate, handler]);
  };
  INotifyPropertyChanged.prototype.removePropertyChangeListener3 = function(predicate, handler){
    var _listeners = this["__pListeners"];
    if(_listeners == null)
    {
      return;
    }
    _listeners.forEach((function(pp, index, array){
      if(pp[0] === predicate && pp[1] == handler)
      {
        _listeners.splice(index, 1);
        return;
      }
    }).bind(this));
  };
  INotifyPropertyChanged.prototype.__class = new (__lc('java.lang.Class'))("java.lang.INotifyPropertyChanged", INotifyPropertyChanged, Object.prototype.__class, [], 2);
  return  INotifyPropertyChanged;
})();
(function(){ 
  function INotifyCollectionChanged(){};
  __cache["java.lang.INotifyCollectionChanged"] = INotifyCollectionChanged;
  INotifyCollectionChanged.prototype.__class = new (__lc('java.lang.Class'))("java.lang.INotifyCollectionChanged", INotifyCollectionChanged, Object.prototype.__class, [], 2);
  return  INotifyCollectionChanged;
})();
(function(){ 
  function CollectionChangedAction() {    
  __lc('java.lang.Enum').call(this, arguments[arguments.length-2], arguments[arguments.length-1]);
  }
  CollectionChangedAction.prototype.__proto__ = __lc("java.lang.Enum").prototype;
  __cache["java.lang.CollectionChangedAction"] = CollectionChangedAction;
  CollectionChangedAction.valueOf = function(name) { return CollectionChangedAction[name]; };
  CollectionChangedAction.values = function() { return [CollectionChangedAction.Add, CollectionChangedAction.Move, CollectionChangedAction.Remove, CollectionChangedAction.Replace, CollectionChangedAction.Reset]; };
  CollectionChangedAction.Add = new (__lc('java.lang.CollectionChangedAction'))("Add", 0);
  CollectionChangedAction.Move = new (__lc('java.lang.CollectionChangedAction'))("Move", 1);
  CollectionChangedAction.Remove = new (__lc('java.lang.CollectionChangedAction'))("Remove", 2);
  CollectionChangedAction.Replace = new (__lc('java.lang.CollectionChangedAction'))("Replace", 3);
  CollectionChangedAction.Reset = new (__lc('java.lang.CollectionChangedAction'))("Reset", 4);
  CollectionChangedAction.prototype.__class = new (__lc('java.lang.Class'))("java.lang.CollectionChangedAction", CollectionChangedAction, __lc("java.lang.Enum").prototype.__class, [], 3);
  return  CollectionChangedAction;
})();
(function(){ 
  function CollectionChangedEvent(){
    var args = Array.prototype.slice.call(arguments);
    return CollectionChangedEvent.__f[args[args.length-1]].apply(this, args.slice(0, args.length-1));
  }
  CollectionChangedEvent.__f = {
    "1" : function(action) {    
    this._action = null;
    this._newItems = null;
    this._oldItems = null;
    this._newStartingIndex = - 1;
    this._oldStartingIndex = - 1;
    if(action != __lc("java.lang.CollectionChangedAction").Reset) throw new Error(0, "Action must be CollectionChangedAction.Reset")
    initializeAdd.call(this, action, null, - 1);
  }, 
    "2" : function(action, changedItem) {    
    this._action = null;
    this._newItems = null;
    this._oldItems = null;
    this._newStartingIndex = - 1;
    this._oldStartingIndex = - 1;
    if((action != __lc("java.lang.CollectionChangedAction").Add) && (action != __lc("java.lang.CollectionChangedAction").Remove) && (action != __lc("java.lang.CollectionChangedAction").Reset)) throw new Error(0, "Action must be CollectionChangedAction.Reset or CollectionChangedAction.Remove")
    if(action == __lc("java.lang.CollectionChangedAction").Reset)
    {
      if(changedItem != null) throw new Error(0, "ResetAction requires null changedItems")
      initializeAdd.call(this, action, null, - 1);
    }
    else
    {
      initializeAddOrRemove.call(this, action, [changedItem], - 1);
    }
  }, 
    "3" : function(action, changedItem, index) {    
    this._action = null;
    this._newItems = null;
    this._oldItems = null;
    this._newStartingIndex = - 1;
    this._oldStartingIndex = - 1;
    if((action != __lc("java.lang.CollectionChangedAction").Add) && (action != __lc("java.lang.CollectionChangedAction").Remove) && (action != __lc("java.lang.CollectionChangedAction").Reset)) throw new Error(0, "Action must be CollectionChangedAction.Add or CollectionChangedAction.Remove or CollectionChangedAction.Reset")
    if(action == __lc("java.lang.CollectionChangedAction").Reset)
    {
      if(changedItem != null) throw new Error(0, "ResetAction requires null changedItems")
      if(index != - 1) throw new Error(0, "ResetAction requires index minus 1")
      initializeAdd.call(this, action, null, - 1);
    }
    else
    {
      initializeAddOrRemove.call(this, action, [changedItem], index);
    }
  }, 
    "4" : function(action, changedItems) {    
    this._action = null;
    this._newItems = null;
    this._oldItems = null;
    this._newStartingIndex = - 1;
    this._oldStartingIndex = - 1;
    if((action != __lc("java.lang.CollectionChangedAction").Add) && (action != __lc("java.lang.CollectionChangedAction").Remove) && (action != __lc("java.lang.CollectionChangedAction").Reset)) throw new Error(0, "Action must be CollectionChangedAction.Add or CollectionChangedAction.Remove or CollectionChangedAction.Reset")
    if(action == __lc("java.lang.CollectionChangedAction").Reset)
    {
      if(changedItems != null) throw new Error(0, "ResetAction requires null changedItems")
      initializeAdd.call(this, action, null, - 1);
    }
    else
    {
      if(changedItems == null) throw new Error(0, "ResetAction requires null changedItems")
      initializeAddOrRemove.call(this, action, changedItems, - 1);
    }
  }, 
    "5" : function(action, changedItems, startingIndex) {    
    this._action = null;
    this._newItems = null;
    this._oldItems = null;
    this._newStartingIndex = - 1;
    this._oldStartingIndex = - 1;
    if((action != __lc("java.lang.CollectionChangedAction").Add) && (action != __lc("java.lang.CollectionChangedAction").Remove) && (action != __lc("java.lang.CollectionChangedAction").Reset)) throw new Error(0, "Action must be NotifyCollectionChangedAction.Add or CollectionChangedAction.Remove or CollectionChangedAction.Reset")
    if(action == __lc("java.lang.CollectionChangedAction").Reset)
    {
      if(changedItems != null) throw new Error(0, "ResetAction requires null changedItems")
      if(startingIndex != - 1) throw new Error(0, "ResetAction requires index minus 1")
      initializeAdd.call(this, action, null, - 1);
    }
    else
    {
      if(changedItems == null) throw new Error(0, "changedItems may not be null!")
      if(startingIndex < - 1) throw new Error(0, "Index cannot be negative")
      initializeAddOrRemove.call(this, action, changedItems, startingIndex);
    }
  }, 
    "6" : function(action, newItem, oldItem) {    
    this._action = null;
    this._newItems = null;
    this._oldItems = null;
    this._newStartingIndex = - 1;
    this._oldStartingIndex = - 1;
    if(action != __lc("java.lang.CollectionChangedAction").Replace) throw new Error(0, "Action must be NotifyCollectionChangedAction.Replace")
    initializeMoveOrReplace.call(this, action, [newItem], [oldItem], - 1, - 1);
  }, 
    "7" : function(action, newItem, oldItem, index) {    
    this._action = null;
    this._newItems = null;
    this._oldItems = null;
    this._newStartingIndex = - 1;
    this._oldStartingIndex = - 1;
    if(action != __lc("java.lang.CollectionChangedAction").Replace) throw new Error(0, "Action must be CollectionChangedAction.Replace")
    initializeMoveOrReplace.call(this, action, [newItem], [oldItem], index, index);
  }, 
    "8" : function(action, newItems, oldItems) {    
    this._action = null;
    this._newItems = null;
    this._oldItems = null;
    this._newStartingIndex = - 1;
    this._oldStartingIndex = - 1;
    if(action != __lc("java.lang.CollectionChangedAction").Replace) throw new Error(0, "Action must be CollectionChangedAction.Replace")
    if(newItems == null) throw new Error(0, "changedItems may not be null!")
    if(oldItems == null) throw new Error(0, "oldItems may not be null!")
    initializeMoveOrReplace.call(this, action, newItems, oldItems, - 1, - 1);
  }, 
    "9" : function(action, newItems, oldItems, startingIndex) {    
    this._action = null;
    this._newItems = null;
    this._oldItems = null;
    this._newStartingIndex = - 1;
    this._oldStartingIndex = - 1;
    if(action != __lc("java.lang.CollectionChangedAction").Replace) throw new Error(0, "Action must be CollectionChangedAction.Replace")
    if(newItems == null) throw new Error(0, "changedItems may not be null!")
    if(oldItems == null) throw new Error(0, "oldItems may not be null!")
    initializeMoveOrReplace.call(this, action, newItems, oldItems, startingIndex, startingIndex);
  }, 
    "10" : function(action, changedItem, index, oldIndex) {    
    this._action = null;
    this._newItems = null;
    this._oldItems = null;
    this._newStartingIndex = - 1;
    this._oldStartingIndex = - 1;
    if(action != __lc("java.lang.CollectionChangedAction").Move) throw new Error(0, "Action must be CollectionChangedAction.Move")
    if(index < 0) throw new Error(0, "Index cannot be negative")
    var changedItems = new Array(changedItem);
    initializeMoveOrReplace.call(this, action, changedItems, changedItems, index, oldIndex);
  }, 
    "11" : function(action, changedItems, index, oldIndex) {    
    this._action = null;
    this._newItems = null;
    this._oldItems = null;
    this._newStartingIndex = - 1;
    this._oldStartingIndex = - 1;
    if(action != __lc("java.lang.CollectionChangedAction").Move) throw new Error(0, "Action must be CollectionChangedAction.Move")
    if(index < 0) throw new Error(0, "Index cannot be negative")
    initializeMoveOrReplace.call(this, action, changedItems, changedItems, index, oldIndex);
  }, 
    "12" : function(action, newItems, oldItems, newIndex, oldIndex) {    
    this._action = null;
    this._newItems = null;
    this._oldItems = null;
    this._newStartingIndex = - 1;
    this._oldStartingIndex = - 1;
    this._action = action;
    this._newItems = (newItems == null) ? null : newItems;
    this._oldItems = (oldItems == null) ? null : oldItems;
    this._newStartingIndex = newIndex;
    this._oldStartingIndex = oldIndex;
  }
  };
  CollectionChangedEvent.prototype.__proto__ = Object.prototype;
  __cache["java.lang.CollectionChangedEvent"] = CollectionChangedEvent;
  Object.defineProperty(CollectionChangedEvent.prototype, "action", {
    get : function() {
      return this._action;
    }
  });
  Object.defineProperty(CollectionChangedEvent.prototype, "newItems", {
    get : function() {
      return this._newItems;
    }
  });
  Object.defineProperty(CollectionChangedEvent.prototype, "oldItems", {
    get : function() {
      return this._oldItems;
    }
  });
  Object.defineProperty(CollectionChangedEvent.prototype, "newStartingIndex", {
    get : function() {
      return this._newStartingIndex;
    }
  });
  Object.defineProperty(CollectionChangedEvent.prototype, "oldStartingIndex", {
    get : function() {
      return this._oldStartingIndex;
    }
  });
  function initializeAddOrRemove(action, changedItems, startingIndex){
    if(action == __lc("java.lang.CollectionChangedAction").Add) initializeAdd.call(this, action, changedItems, startingIndex)
    else if(action == __lc("java.lang.CollectionChangedAction").Remove) initializeRemove.call(this, action, changedItems, startingIndex)
  }
  function initializeAdd(action, newItems, newStartingIndex){
    this._action = action;
    this._newItems = (newItems == null) ? null : newItems;
    this._newStartingIndex = newStartingIndex;
  }
  function initializeRemove(action, oldItems, oldStartingIndex){
    this._action = action;
    this._oldItems = (oldItems == null) ? null : oldItems;
    this._oldStartingIndex = oldStartingIndex;
  }
  function initializeMoveOrReplace(action, newItems, oldItems, startingIndex, oldStartingIndex){
    initializeAdd.call(this, action, newItems, startingIndex);
    initializeRemove.call(this, action, oldItems, oldStartingIndex);
  }
  CollectionChangedEvent.prototype.__class = new (__lc('java.lang.Class'))("java.lang.CollectionChangedEvent", CollectionChangedEvent, Object.prototype.__class, [], 1);
  return  CollectionChangedEvent;
})();
(function(){ 
  function PropertyChangeEvent(property) {    
    this._property = null;
    this._property = property;
  }
  PropertyChangeEvent.prototype.__proto__ = Object.prototype;
  __cache["java.lang.PropertyChangeEvent"] = PropertyChangeEvent;
  Object.defineProperty(PropertyChangeEvent.prototype, "property", {
    get : function() {
      return this._property;
    }
  });
  PropertyChangeEvent.prototype.__class = new (__lc('java.lang.Class'))("java.lang.PropertyChangeEvent", PropertyChangeEvent, Object.prototype.__class, [], 1);
  return  PropertyChangeEvent;
})();
