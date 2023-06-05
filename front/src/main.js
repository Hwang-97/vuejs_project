// import './scss/common.scss'
import { createApp } from 'vue'
import Vue from 'vue'
import Vuex from 'vuex'
import store from "./store";
import App from './App.vue'
import router from './routes/index.js'
import cmmnPlugin from './util/cmmnPlugin.js';

createApp(App)
    .use(router)
    .use(Vuex)
    .use(store)
    .use(cmmnPlugin)
    .mount('#app')
