import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import login from '@/components/login'
import index from '@/components/index'
import ApplyOrganization from '@/components/ApplyOrganization'
import PersonInfo from "@/components/PersonInfo"
// const PersonInfo = r => require.ensure([], () => r(require('../components/PersonInfo')), 'PersonInfo');
const logout = r => require.ensure([], () => r(require('../components/logout')), 'logout');
// const Component404 = require.ensure([], () => r(require('../components/404')), 'page404');
import test from "@/components/test"
Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'ttttt',
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
    },
    {
      path: '/setting',
      name: '/setting',
      component: PersonInfo
    },
    {
      path: '/logout',
      name: '/logout',
      component: logout
    },
    {
      path: "*",
      redirect: "/"
    },
    {
      path: '/test',
      name: 'test',
      component: test,

    }

  ]
})
