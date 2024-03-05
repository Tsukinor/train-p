/*
* store是用来存储组件状态的,而不是用来做本地数据存储的。刷新页面时,vue实例重新加载,从而store也被重置，其中的用户信息将丢失。
* 解决方法：可以把store存入本地localStorage、sessionStorage、cookie中：
*         localStorage是永久储存，重新打开页面时会读取上一次打开的页面数据
*         sessionStorage是储存到关闭为止
*         cookie不适合存大量数据。
* */
import { createStore } from 'vuex'

export default createStore({
  // state内声明了数据对象，相当于Java的实体类
  state: {
  },
  // 除非存在数值类型等转换，否则直接通过state.xxx访问即可
  getters: {
  },
  // mutations内说明了对数据对象的赋值操作，相当于Java的setter()
  mutations: {
  },
  // actions内声明异步任务
  actions: {
  },
  // 若项目较大，可将上述内容模块化
  modules: {
  }
})
