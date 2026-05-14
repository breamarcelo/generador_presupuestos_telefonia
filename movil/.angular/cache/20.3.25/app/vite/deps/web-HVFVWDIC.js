import {
  WebPlugin
} from "./chunk-KTTHYQLP.js";
import {
  __async
} from "./chunk-TXDUYLVM.js";

// node_modules/@capacitor-community/http/dist/esm/utils.js
var readBlobAsBase64 = (blob) => __async(null, null, function* () {
  return new Promise((resolve, reject) => {
    const reader = new FileReader();
    reader.onload = () => {
      const base64String = reader.result;
      const base64StringWithoutTags = base64String.substr(base64String.indexOf(",") + 1);
      resolve(base64StringWithoutTags);
    };
    reader.onerror = (error) => reject(error);
    reader.readAsDataURL(blob);
  });
});
var encode = (str) => encodeURIComponent(str).replace(/%(2[346B]|5E|60|7C)/g, decodeURIComponent).replace(/[()]/g, escape);
var decode = (str) => str.replace(/(%[\dA-F]{2})+/gi, decodeURIComponent);

// node_modules/@capacitor-community/http/dist/esm/cookie.js
var setCookie = (key, value, options = {}) => {
  const encodedKey = encode(key);
  const encodedValue = encode(value);
  const expires = `; expires=${(options.expires || "").replace("expires=", "")}`;
  const path = (options.path || "/").replace("path=", "");
  document.cookie = `${encodedKey}=${encodedValue || ""}${expires}; path=${path}`;
};
var getCookies = () => {
  const output = [];
  const map = {};
  if (!document.cookie) {
    return output;
  }
  const cookies = document.cookie.split(";") || [];
  for (const cookie of cookies) {
    let [k, v] = cookie.replace(/=/, "CAP_COOKIE").split("CAP_COOKIE");
    k = decode(k).trim();
    v = decode(v).trim();
    map[k] = v;
  }
  const entries = Object.entries(map);
  for (const [key, value] of entries) {
    output.push({
      key,
      value
    });
  }
  return output;
};
var getCookie = (key) => {
  const cookies = getCookies();
  for (const cookie of cookies) {
    if (cookie.key === key) {
      return cookie;
    }
  }
  return {
    key,
    value: ""
  };
};
var deleteCookie = (key) => {
  document.cookie = `${key}=; Max-Age=0`;
};
var clearCookies = () => {
  const cookies = document.cookie.split(";") || [];
  for (const cookie of cookies) {
    document.cookie = cookie.replace(/^ +/, "").replace(/=.*/, `=;expires=${(/* @__PURE__ */ new Date()).toUTCString()};path=/`);
  }
};

// node_modules/@capacitor-community/http/dist/esm/request.js
var normalizeHttpHeaders = (headers = {}) => {
  const originalKeys = Object.keys(headers);
  const loweredKeys = Object.keys(headers).map((k) => k.toLocaleLowerCase());
  const normalized = loweredKeys.reduce((acc, key, index) => {
    acc[key] = headers[originalKeys[index]];
    return acc;
  }, {});
  return normalized;
};
var buildUrlParams = (params, shouldEncode = true) => {
  if (!params)
    return null;
  const output = Object.entries(params).reduce((accumulator, entry) => {
    const [key, value] = entry;
    let encodedValue;
    let item;
    if (Array.isArray(value)) {
      item = "";
      value.forEach((str) => {
        encodedValue = shouldEncode ? encodeURIComponent(str) : str;
        item += `${key}=${encodedValue}&`;
      });
      item.slice(0, -1);
    } else {
      encodedValue = shouldEncode ? encodeURIComponent(value) : value;
      item = `${key}=${encodedValue}`;
    }
    return `${accumulator}&${item}`;
  }, "");
  return output.substr(1);
};
var buildRequestInit = (options, extra = {}) => {
  const output = Object.assign({ method: options.method || "GET", headers: options.headers }, extra);
  const headers = normalizeHttpHeaders(options.headers);
  const type = headers["content-type"] || "";
  if (typeof options.data === "string") {
    output.body = options.data;
  } else if (type.includes("application/x-www-form-urlencoded")) {
    const params = new URLSearchParams();
    for (const [key, value] of Object.entries(options.data || {})) {
      params.set(key, value);
    }
    output.body = params.toString();
  } else if (type.includes("multipart/form-data")) {
    const form = new FormData();
    if (options.data instanceof FormData) {
      options.data.forEach((value, key) => {
        form.append(key, value);
      });
    } else {
      for (let key of Object.keys(options.data)) {
        form.append(key, options.data[key]);
      }
    }
    output.body = form;
    const headers2 = new Headers(output.headers);
    headers2.delete("content-type");
    output.headers = headers2;
  } else if (type.includes("application/json") || typeof options.data === "object") {
    output.body = JSON.stringify(options.data);
  }
  return output;
};
var request = (options) => __async(null, null, function* () {
  const requestInit = buildRequestInit(options, options.webFetchExtra);
  const urlParams = buildUrlParams(options.params, options.shouldEncodeUrlParams);
  const url = urlParams ? `${options.url}?${urlParams}` : options.url;
  const response = yield fetch(url, requestInit);
  const contentType = response.headers.get("content-type") || "";
  let { responseType = "text" } = response.ok ? options : {};
  if (contentType.includes("application/json")) {
    responseType = "json";
  }
  let data;
  switch (responseType) {
    case "arraybuffer":
    case "blob":
      const blob = yield response.blob();
      data = yield readBlobAsBase64(blob);
      break;
    case "json":
      data = yield response.json();
      break;
    case "document":
    case "text":
    default:
      data = yield response.text();
  }
  const headers = {};
  response.headers.forEach((value, key) => {
    headers[key] = value;
  });
  return {
    data,
    headers,
    status: response.status,
    url: response.url
  };
});
var get = (options) => __async(null, null, function* () {
  return request(Object.assign(Object.assign({}, options), { method: "GET" }));
});
var post = (options) => __async(null, null, function* () {
  return request(Object.assign(Object.assign({}, options), { method: "POST" }));
});
var put = (options) => __async(null, null, function* () {
  return request(Object.assign(Object.assign({}, options), { method: "PUT" }));
});
var patch = (options) => __async(null, null, function* () {
  return request(Object.assign(Object.assign({}, options), { method: "PATCH" }));
});
var del = (options) => __async(null, null, function* () {
  return request(Object.assign(Object.assign({}, options), { method: "DELETE" }));
});

// node_modules/@capacitor-community/http/dist/esm/web.js
var HttpWeb = class extends WebPlugin {
  constructor() {
    super();
    this.request = (options) => __async(this, null, function* () {
      return request(options);
    });
    this.get = (options) => __async(this, null, function* () {
      return get(options);
    });
    this.post = (options) => __async(this, null, function* () {
      return post(options);
    });
    this.put = (options) => __async(this, null, function* () {
      return put(options);
    });
    this.patch = (options) => __async(this, null, function* () {
      return patch(options);
    });
    this.del = (options) => __async(this, null, function* () {
      return del(options);
    });
    this.getCookiesMap = (options) => __async(this, null, function* () {
      const cookies = getCookies();
      const output = {};
      for (const cookie of cookies) {
        output[cookie.key] = cookie.value;
      }
      return output;
    });
    this.getCookies = (options) => __async(this, null, function* () {
      const { url } = options;
      const cookies = getCookies();
      return { cookies };
    });
    this.setCookie = (options) => __async(this, null, function* () {
      const { key, value, expires = "", path = "" } = options;
      setCookie(key, value, { expires, path });
    });
    this.getCookie = (options) => __async(this, null, function* () {
      return getCookie(options.key);
    });
    this.deleteCookie = (options) => __async(this, null, function* () {
      return deleteCookie(options.key);
    });
    this.clearCookies = (options) => __async(this, null, function* () {
      return clearCookies();
    });
    this.clearAllCookies = () => __async(this, null, function* () {
      return clearCookies();
    });
    this.uploadFile = (options) => __async(this, null, function* () {
      const formData = new FormData();
      formData.append(options.name, options.blob || "undefined");
      const fetchOptions = Object.assign(Object.assign({}, options), { body: formData, method: "POST" });
      return this.post(fetchOptions);
    });
    this.downloadFile = (options) => __async(this, null, function* () {
      const requestInit = buildRequestInit(options, options.webFetchExtra);
      const response = yield fetch(options.url, requestInit);
      let blob;
      if (!(options === null || options === void 0 ? void 0 : options.progress))
        blob = yield response.blob();
      else if (!(response === null || response === void 0 ? void 0 : response.body))
        blob = new Blob();
      else {
        const reader = response.body.getReader();
        let bytes = 0;
        let chunks = [];
        const contentType = response.headers.get("content-type");
        const contentLength = parseInt(response.headers.get("content-length") || "0", 10);
        while (true) {
          const { done, value } = yield reader.read();
          if (done)
            break;
          chunks.push(value);
          bytes += (value === null || value === void 0 ? void 0 : value.length) || 0;
          const status = {
            type: "DOWNLOAD",
            url: options.url,
            bytes,
            contentLength
          };
          this.notifyListeners("progress", status);
        }
        let allChunks = new Uint8Array(bytes);
        let position = 0;
        for (const chunk of chunks) {
          if (typeof chunk === "undefined")
            continue;
          allChunks.set(chunk, position);
          position += chunk.length;
        }
        blob = new Blob([allChunks.buffer], { type: contentType || void 0 });
      }
      return {
        blob
      };
    });
  }
};
export {
  HttpWeb
};
//# sourceMappingURL=web-HVFVWDIC.js.map
