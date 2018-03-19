import Vue from 'vue'
import Vuex from 'vuex'
import userinfo from "./modules/info"
Vue.use(Vuex)

const store = new Vuex.Store({
    modules: {
      info: userinfo,
    }
  });
export default store;
