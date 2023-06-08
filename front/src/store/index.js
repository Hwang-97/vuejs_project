import {createStore} from 'vuex'
import searchModule from "./modules/searchModule";

export default createStore({
  modules: {
    search: searchModule // 모듈 등록
  }
});