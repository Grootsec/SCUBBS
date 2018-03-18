import fetch from "./fetch"

var sendLogin = (zjh, mm) => fetch('/v1/login', {
	zjh,
	mm,	
}, 'POST');

export const signout = () => fetch('/v1/signout');

