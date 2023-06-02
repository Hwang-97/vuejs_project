import Vuex from "vuex";
import searchData from "./searchData";

export default new Vuex.Store({
  state: {
    loaded: false,
    user: null,
    draw: {
      mode: null,
    },
  },
  mutations: {
    setState(s,[key, value]) {
      s[key] = value;
    },
    setDraw(s,payload) {
      s.draw = { ...s.draw, ...payload };
    },
  },
  getters: {
    loaded(s) {
      return s.loaded;
    },
    user(s) {
      return s.user;
    },
    draw(s) {
      return s.draw;
    },
  },
  actions: {

  },
  modules: {
    searchData
  }
});
