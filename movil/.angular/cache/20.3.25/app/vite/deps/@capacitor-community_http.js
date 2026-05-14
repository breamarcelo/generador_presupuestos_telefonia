import {
  registerPlugin
} from "./chunk-KTTHYQLP.js";
import "./chunk-TXDUYLVM.js";

// node_modules/@capacitor-community/http/dist/esm/index.js
var Http = registerPlugin("Http", {
  web: () => import("./web-HVFVWDIC.js").then((m) => new m.HttpWeb()),
  electron: () => import("./web-HVFVWDIC.js").then((m) => new m.HttpWeb())
});
export {
  Http
};
//# sourceMappingURL=@capacitor-community_http.js.map
