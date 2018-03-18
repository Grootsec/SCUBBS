let baseUrl = ''; 
let routerMode = 'hash';
let imgBaseUrl;


if (process.env.NODE_ENV == 'development') {
    
}else if(process.env.NODE_ENV == 'production'){
	baseUrl = 'http://cangdu.org:8001';
}

export {
	baseUrl,
	routerMode,
	imgBaseUrl,
}