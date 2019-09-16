
 var store=window.localStorage;

 //  store.setToken=(val)=>{
 //     store.token=val;
 //  }
 export function setToken(val){
     store.token=val;
 }
 
 export function deleteKey(key){
     store.removeItem(key)
 }
 
 export function getToken(){
     return store.token;
 }
 
 // export default store;