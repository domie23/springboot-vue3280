const base = {
    get() {
        return {
            url : "http://localhost:8080/chongwuyiyuanxinxi/",
            name: "chongwuyiyuanxinxi",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/chongwuyiyuanxinxi/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "宠物医院信息管理系统"
        } 
    }
}
export default base
