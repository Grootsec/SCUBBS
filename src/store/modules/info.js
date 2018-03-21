const userinfo = {
  state: {
    name: '测试', // 用户名字
    no: '123', // 用户编号
    nickname: '',// Nickname
    college: '软件学院', // 用户学院
    cookies: '', // cookies
    avatar: '', // 头像地址
    introduction: '测试', // 简介
    sex: '',
    stuclass: '',
    roles: [], // 角色
  },
  mutations: {
    login(state, info) {
      state.name = info.name;
      state.no = info.no;
      state.nickname = info.nickname;
      state.college = info.college;
      state.avatar = info.avatar;
      state.introduction = info.introduction;
      state.sex = info.sex;
      state.stuclass = info.stuclass;
    }
  }
};
export default userinfo
