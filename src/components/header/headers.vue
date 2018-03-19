<template>
<div>
    <Menu mode="horizontal" :theme="theme1" active-name="1">
        <MenuItem name="1">
            <Icon type="ios-paper"></Icon>
            青春广场
        </MenuItem>
        <MenuItem name="2">
            <Icon type="ios-people"></Icon>
            瞎BB
        </MenuItem>
        <MenuItem name="3">
        <Icon type="heart"></Icon>
            表白墙
        </MenuItem>
        <span style="float: right;">
        <MenuItem name="4">
            <router-link to="/setting" style="color: rgba(255,255,255,.7);">
            <Badge dot>
                <Avatar icon="person" />
            </Badge>
            个人设置
            </router-link>
        </MenuItem>
        </span>
    </Menu>
    </div>
</template>

<script>
    export default {
        data () {
            return {
                theme1: 'dark'
            }
        }
    }
</script>
