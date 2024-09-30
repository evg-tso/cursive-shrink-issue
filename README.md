# cursive-shrink-issue

This is a minimal example to reproduce an issue with cursive's shrink behavior.  
The issue is that Cursive tried to call `clojure.lang.RT.get` to find the `:shrunk` key, but if the implementation of
`APersistentMap` doesn't allow access to "invalid" keys, it will throw an exception.

In our case, we use [pronto](https://github.com/AppsFlyer/pronto) which is a Clojure library that allows us to interact
with Protocol Buffers in a Clojure-friendly way.

However, pronto's `APersistentMap` implementation doesn't allow access to keys that are not defined in the `.proto`
file.  
This causes Cursive to throw an exception, while `lein test ...` works fine.  
Read more about `pronto`'s design
decision [here](https://github.com/AppsFlyer/pronto/tree/master?tab=readme-ov-file#fine-print---please-read).

Issue can be tracked here: https://github.com/cursive-ide/cursive/issues/2966  
