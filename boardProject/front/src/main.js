// import './scss/common.scss'
import { createApp } from 'vue'
import store from "./store";
import App from './App.vue'
import router from './routes/index.js'
import cmmnPlugin from './util/cmmnPlugin.js';

createApp(App)
    .use(router)
    .use(store)
    .use(cmmnPlugin)
    .mount('#app')
