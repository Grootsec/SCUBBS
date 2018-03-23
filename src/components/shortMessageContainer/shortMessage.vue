<template>
<Layout>
  <Row>
    <Col span="6">
    <Card>
      <p slot="title">
        <Avatar>U</Avatar>{{items.username}}
      </p>
      <a href="#" slot="extra" @click.prevent="changeLimit">
        <Icon type="ios-loop-strong"></Icon>
        Change
      </a>
      <span>123</span>
    </Card>
    </Col>
    <Col span="12" class="center-container hide-parent">
    <Scroll class="hide-child" :on-reach-top="handleReachTop" :on-reach-bottom="handleReachBottom">
      <Button type="ghost" long style="margin-bottom:10px">刷新</Button>
      <Card v-for="item in list1" class="card">
        <p slot="title">
          <Avatar>U</Avatar>{{item}}
        </p>
        <a href="#" slot="extra" @click.prevent="changeLimit">
          <Icon type="ios-loop-strong"></Icon>
          Change
        </a>
        <Card>
          <div style="text-align:center">
            <h3>我发的贴</h3>
          </div>
        </Card>
        <p class="ivu-card-footer">123</p>
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
</Layout>
</template>
<script>
export default {
  data() {
    return {
      items: [{
        username: 'tempuser'
      }],
      list2: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
      list1: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
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
          const first = this.list2[0];
          for (let i = 1; i < 11; i++) {
            this.list2.unshift(first - i);
          }
          resolve();
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
          resolve();
        }, 2000);
      });
    }
  },
  mounted() {
    this.changeLimit();
  }
}
</script>

<style media="screen" scoped>
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
</style>
