// modules/searchModule.js
const namespaced = true;
const state = {
    typeFlag: "title",
    searchText: ""
};
const getters = {
    getTypeFlag(state) {
        return state.typeFlag;
    },
    getSearchText(state) {
        return state.searchText;
    }
};
const mutations = {
    setTypeFlag(state,data) {
        state.typeFlag = data
    },
    setSearchText(state,data) {
        state.searchText = data
    }
};

export default {
    namespaced,
    state,
    getters,
    mutations
};
