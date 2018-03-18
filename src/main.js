// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import store from './store/index'
import VueResource from 'vue-resource'
Vue.use(ElementUI);
Vue.use(VueResource);
Vue.config.productionTip = false;
// 使用application/x-www-form-urlencoded作为默认请求格式
Vue.http.options.emulateJSON = true;


/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  router,
  components: { App },
  template: '<App/>',
  render: h => h(App)
});
