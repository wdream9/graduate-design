enum Keys {
    Token = 'netdisk',
    UserId = 'userId',
    ExpireTime = 'expireTime',
}
// sessionStorage中存、取token
export const setTokenSession = (token: string) => {
    sessionStorage.setItem(Keys.Token, token)
}
export const getTokenSession = () => {
    return sessionStorage.getItem(Keys.Token)
}
// 从sessionStorage 中移除token
export const removeToken = () => {
    //3,删除
    // sessionStorage.removeItem(key);
    //4,清除数据-----删除所有同源的本地存储的localStorage数据
    // localStorage.clear();
    //5,清除数据-----只清空当前会话存储的数据
    sessionStorage.clear();
}
//存储userId到sessionStorage
export const setUserIdSession = (userId: number) => {
    sessionStorage.setItem(Keys.UserId, JSON.stringify(userId))
}
export const getUserIdSession = () => {
    return sessionStorage.getItem(Keys.Token)
}
//存储expiretime到sessionStorage
export const setExpireTime = (time: number) => {
    sessionStorage.setItem(Keys.ExpireTime, JSON.stringify(time))
}
export const getExpireTime = () => {
    return sessionStorage.getItem(Keys.ExpireTime)
}


// cookies中获取token
export const getTokenCookie = (name: string) => {
    var arrStr = document.cookie.split("; ");
    for (var i = 0; i < arrStr.length; i++) {
        var temp = arrStr[i].split("=");
        if (temp[0] == name) {
            return decodeURI(temp[1]);
        }
    }
}
// 存储token到cookies中
export const setTokenCookie = (token: string, expireTime: number,path?:string) => {
    // expireTime 毫秒值
    var d = new Date();
    d.setTime(d.getTime() + expireTime);
    document.cookie = `netdisk=${token}; expires=${d.toUTCString()}; path=${path? path :'/'}`;
}

// 从cookie中移除token
export const removeCookie = (cname: any) => {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    var cookieStr = "";
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) == 0) {
            document.cookie = c + ';expires=' + new Date(0).toUTCString()
        } else {
            cookieStr += c;
            cookieStr += ";";
        }
        document.cookie = cookieStr;
    }
}


