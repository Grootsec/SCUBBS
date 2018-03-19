const userinfo = {
    state: {
      name: '测试', // 用户名字
      no: '123', // 用户编号
      nickname: '123',// Nickname
      college: '软件学院', // 用户学院
      cookies:'', // cookies
      avatar: 'https://i.loli.net/2017/08/21/599a521472424.jpg', // 头像地址
      introduction: '', // 简介
      roles: [], // 角色
    },
    mutations: {
      login(state, info){
        state.name = info.name,
        state.no = info.no,
        state.nickname = info.nickname,
        state.college = info.college,
        state.avatar = info.avatar,
        state.introduction = info.introduction,
        state.roles.push(info.roles)
      }
    }
};
export default userinfo
