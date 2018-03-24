<template>
<Layout>
  <Row>
    <Col span="6">
    <Card>
      <p slot="title">
        <Avatar>U</Avatar>我叫孔旻昊
      </p>
      <a href="#" slot="extra" @click.prevent="changeLimit">
        <Icon type="ios-loop-strong"></Icon>
        设置
      </a>
      <table>
        <tr>
          <td>姓名</td>
          <td>孔旻昊</td>
        </tr>
        <tr>
          <td>昵称</td>
          <td>{{this.$store.state.info.nickname}}</td>
        </tr>
        <tr>
          <td>发消息数</td>
          <td>12222</td>
        </tr>
        <tr>
          <td>获得的赞</td>
          <td>12222</td>
        </tr>
        <tr>
          <td>获得的评论数</td>
          <td>12222</td>
        </tr>
      </table>
    </Card>
    <Button type="primary" @click="modal1 = true" long>发消息</Button>
    </Col>
    <Col span="12" class="center-container hide-parent">
    <Scroll class="hide-child" :on-reach-top="handleReachTop" :on-reach-bottom="handleReachBottom">
      <Button type="info" long style="margin-bottom:10px">刷新</Button>
      <Card v-for="item in list" class="card">
        <p slot="title">
          <Avatar :src="item.icon"></Avatar>{{item.nickname}}
        </p>
        <div slot="extra">
          <Button type="ghost" shape="circle" icon="heart" @click="success">喜欢{{item.goodcount}}</Button>
          <Button type="error" shape="circle" icon="fireball">举报{{item.badcount}}</Button>
        </div>
        <Card>
          <div style="text-align:center">
            <h3 v-html="replaceContent(item.content)"></h3>
          </div>
        </Card>
        <Button shape="circle" type="ghost" @click="handleMoreClick(item)" long>更多</Button>
      </Card>
    </Scroll>
    </Col>
    <Col span="6">
    <Card>
      <p slot="title">
        <Avatar>A</Avatar>最热消息
      </p>
      <a href="#" slot="extra" @click.prevent="changeLimit">
        <Icon type="ios-loop-strong"></Icon>
        这个地方就算了吧
      </a>
      <Table border :columns="columns1" :data="data1"></Table>
    </Card>
    <Card>
      <p slot="title">
        <Avatar src="https://i.loli.net/2017/08/21/599a521472424.jpg">A</Avatar>最热评论
      </p>
      <a href="#" slot="extra" @click.prevent="changeLimit">
        <Icon type="ios-loop-strong"></Icon>
        测试
      </a>
      <span>软件学院</span>
    </Card>
    </Col>
  </Row>
  <Modal v-model="modal1" title="发帖">
    <TextEdit></TextEdit>
    <div slot="footer">
    </div>
  </Modal>
  <Modal v-model="modal2">
    <MessageBox :post="item"></MessageBox>
    <div slot="footer">
      <Button type="ghost" long @click="modal2 = false">关闭</Button>
    </div>
  </Modal>
</Layout>
</template>
<script>
import TextEdit from '../textedit/TextEdit.vue';
import MessageBox from './MessageBox.vue';

export default {
  data() {
    return {
      modal1: false,
      modal2: false,
      item: [],
      items: [{
        username: 'tempuser'
      }],
      list2: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
      list1: [],
      columns1: [{
          title: 'Name',
          key: 'name'
        },
        {
          title: 'Age',
          key: 'age'
        },
        {
          title: 'Address',
          key: 'address'
        }
      ],
      data1: [{
          name: 'John Brown',
          age: 18,
          address: 'New York No. 1 Lake Park',
          date: '2016-10-03'
        },
        {
          name: 'Jim Green',
          age: 24,
          address: 'London No. 1 Lake Park',
          date: '2016-10-01'
        },
        {
          name: 'Joe Black',
          age: 30,
          address: 'Sydney No. 1 Lake Park',
          date: '2016-10-02'
        },
        {
          name: 'Jon Snow',
          age: 26,
          address: 'Ottawa No. 2 Lake Park',
          date: '2016-10-04'
        }
      ]
    }
  },
  methods: {
    changeLimit() {},
    handleReachTop() {
      return new Promise(resolve => {
        setTimeout(() => {
          resolve(this.$http.get('/api/v1/getMessageById?id=0&type=0').then(function(res){
            this.list1 = res.body.info;
          }));
        }, 2000);
      });
    },
    handleReachBottom() {
      return new Promise(resolve => {
        setTimeout(() => {
          const last = this.list1[this.list1.length - 1];
          for (let i = 1; i < 11; i++) {
            this.list1.push(last + i);
          }
          resolve(this.$http.get('/api/v1/getMessageById?type=0&id=' + last.messageid).then(function (res) {
            if (res.body.code == 0) {
              res.body.info.forEach(e => {
                this.list1.push(e);
              });
              this.$Message.success({
                content: '刷新成功',
                duration: 0.5,
                closable: true
              })
            }
          }));
        }, 2000);
      });
    },
    ok() {
      this.$Message.info('Clicked ok');
    },
    success() {
      this.$Message.success('This is a success tip');
    },
    handleMoreClick(item){
      this.modal2 = true;
      this.item = item;
    },
    filterContent(info) {
      info = info.replace(/@(.*?) /g, ' ');
      info = info.replace(/丨.*/g, ' ');
      return info
    },
    replaceContent(content){
      let info = content.replace(/丨.*/g,' ');
      this.$store.state.addressInfo.address.forEach(e => {
        let url = '#/user/' + e.value;
        info = info.replace('@'+e.value,  '<a href=' +url+'>' + '@' + e.label + '</a>');
      });
      return info;
    },
  },
  mounted() {
    this.changeLimit();
    this.$http.get('/api/v1/getMessageById?id=0&type=0').then(function(res){
      this.list1 = res.body.info;
    })
  },
  computed:{
    list(){
      return this.list1;
    }
  },
  components: {
    TextEdit,
    MessageBox
  }
}
</script>

<style media="screen">
.center-container {
  padding: 0px 1rem;
}

.card {
  width: 100%;
}

.ivu-card-bordered {
  margin-bottom: 1rem;
}

.ivu-card-head p,
.ivu-card-head-inner {
  height: auto;
}

.ivu-card-footer {}

.hide-parent {
  overflow: hidden;
}

.hide-child {
  right: -30px;
}

.ivu-scroll-container {
  height: 80vh !important;
}

.ivu-scroll-content {
  padding-right: 3rem;
}

.ivu-scroll-loader-wrapper {
  margin-right: 3rem;
}

.ivu-avatar {
  margin-right: 0.5rem;
}
</style>
