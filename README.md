This project is edited from [cljs-electron](https://github.com/Gonzih/cljs-electron).

# Tools required

* Clojure and Leiningen
* Node.js
* Install electron: `npm install -g electron`. To install specific version, use `npm install -g electron@6.0.0`

# Development

* Prepare environment

Prepare building, this creates entry point for Electron app.

```bash
make prepare-dev
```

* (Optional) Using SCSS

If you wish to use SASS, you can use `npm run watch:sass` or `make dev-sass`, then editing `scss` files will be live reloaded.

* Start electron

Enter the project directory and run `electron .`, The electron window will open.

* Start development

In Emacs, run `cider-jack-in-cljs` select `figwheel` to start REPL, or from the command line,

```bash
lein figwheel
```

You may notice the REPL blocked with the message `Prompt will show when Figwheel
connects to your application`. Select the electron window, press `Ctrl+Shift+R`
to force a reload, edit `ui_src/ui/core.cljs` and now live reloading should work.



# Build for release

Run

```bash
make build
```
