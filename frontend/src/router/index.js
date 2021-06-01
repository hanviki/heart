import Vue from 'vue'
import Router from 'vue-router'
import MenuView from '@/views/common/MenuView'
import PageView from '@/views/common/PageView'
import LoginView from '@/views/login/Common'
import MobileLoginView from '@/views/heart/Mobile/Mobile'
import dataList from '@/views/heart/HeartBPatientinfo/List'
import EmptyPageView from '@/views/common/EmptyPageView'
import HomePageView from '@/views/HomePage'
import db from 'utils/localstorage'
import request from 'utils/request'
import store from '../store'

// 全局Router异常处理
const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => {
    if (typeof err !== 'undefined') console.log(err)
  })
}
Vue.use(Router)

let constRouter = [{
    path: '/login',
    name: '登录页',
    component: LoginView
  },
  {
    path: '/heart/info',
    name: '数据主表',
    component: dataList
  },
  {
    path: '/mobile/login',
    name: '手机登录页',
    component: MobileLoginView
  },
  {
    path: '/index',
    name: '首页',
    redirect: '/home'
  }
]

let router = new Router({
  routes: constRouter
})

const whiteList = ['/login', '/mobile/login', '/heart/info']

let asyncRouter

// 导航守卫，渲染动态路由
router.beforeEach((to, from, next) => {
  if (whiteList.indexOf(to.path) !== -1) {
    next()
  }
  let token = db.get('USER_TOKEN')
  let user = db.get('USER')
  let userRouter = get('USER_ROUTER')
  if (token.length && user) {
    if (isMobile()) { //是手机端 直接进入列表页
      next('/heart/info')
    } 
    else {
    if (!asyncRouter) {
      if (!userRouter) {
        request.get(`menu/${user.username}`).then((res) => {
          asyncRouter = res.data
          save('USER_ROUTER', asyncRouter)
          go(to, next)
        }).catch(err => {
          console.error(err)
        })
      } else {
        asyncRouter = userRouter
        go(to, next)
      }
    } else {
      next()
    }
  }
  } else {
    if (isMobile()) {
      next('/mobile/login')
    } else {
      next('/login')
    }
  }
})

function go(to, next) {
  asyncRouter = filterAsyncRouter(asyncRouter)
  router.addRoutes(asyncRouter)
  next({
    ...to,
    replace: true
  })
}

function save(name, data) {
  localStorage.setItem(name, JSON.stringify(data))
}


function get(name) {
  return JSON.parse(localStorage.getItem(name))
}

function isMobile() {
  if (
    navigator.userAgent.match(
      /(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i
    )
  ) {
    return true
  }
  return false
}

function filterAsyncRouter(routes) {
  return routes.filter((route) => {
    let component = route.component
    if (component) {
      switch (route.component) {
        case 'MenuView':
          route.component = MenuView
          break
        case 'PageView':
          route.component = PageView
          break
        case 'EmptyPageView':
          route.component = EmptyPageView
          break
        case 'HomePageView':
          route.component = HomePageView
          break
        default:
          route.component = view(component)
      }
      if (route.children && route.children.length) {
        route.children = filterAsyncRouter(route.children)
      }
      return true
    }
  })
}

function view(path) {
  return function (resolve) {
    import(`@/views/${path}.vue`).then(mod => {
      resolve(mod)
    })
  }
}

export default router
