const namespaced = true;
const state= {
    flag : "",
    searchText : ""
};
const getters = {
    getSearchData(stat){
        return {
            flag : stat.flag,
            searchText : stat.searchText,
        }
    }
};
const mutations = {
    setData(state,data){
        state.flag = data.flag;
        state.searchText = data.searchText;
    },
    resetData(state){
        state.flag = "";
        state.searchText = "";
    }
};
export default {
    namespaced,
    state,
    mutations,
    getters
};
