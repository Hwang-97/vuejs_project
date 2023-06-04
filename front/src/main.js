// import './scss/common.scss'
import { createApp } from 'vue'
import Vuex from 'vuex'
import store from "./store";
import App from './App.vue'
import router from './routes/index.js'

createApp(App)
    .use(router)
    .use(Vuex)
    .use(store)
    .mount('#app')
