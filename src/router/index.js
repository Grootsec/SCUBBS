import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import login from '@/components/login'
import index from '@/components/index'
import ApplyOrganization from '@/components/ApplyOrganization'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path:'/login',
      name:'ttttt',
      component: login
    },
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path: '/ApplyOrganization',
      name: 'ApplyOrganization',
      component: ApplyOrganization
    }

  ]
})
