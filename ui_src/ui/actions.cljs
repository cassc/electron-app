(ns ui.actions
  (:require
   [ui.db :as db]
   [ui.utils :as utils]
   [ui.ws-client :as ws]

   [taoensso.timbre :as t]
   [clojure.core.async :refer [go go-loop timeout <! >!]]
   [clojure.string :as s :refer [split-lines]]
   [cljs-uuid-utils.core :as uuid]
   [goog.object :as go])
  (:import
   [goog.string]
   [goog.dom]))

(defn animate [to? element props]
  (let [p (clj->js props)]
    (if to?
      (js/gsap.to element p)
      (js/gsap.from element p))))

(def animate-to (partial animate true))
(def animate-from (partial animate false))

(defn- update-box-pos
  [{:keys [x y up? rotation]}]
  (let [{:keys [w h]} (utils/window-size)
        _             (t/info "window size: " w h)
        x             (+ x 100)
        x             (if (> x w) 0 x)
        rotation      (or rotation 360)
        y             (if up? 50 (- h 100 50))]
    {:x x :y y :up? (not up?) :rotation (- rotation)}))

(defn box-next-position []
  (-> (swap! db/app-state update :box update-box-pos)
      (:box)
      (select-keys [:x :y])))


(defonce initer
  (delay
    (t/info "add your init scripts here")
    ))


;; Rich comment block with redefined vars ignored
#_{:clj-kondo/ignore [:redefined-var]}
(comment

  (animate ".box" {:duration 3
                   :y        100
                   :x        30}  )

  ) ;; End of rich comment block
