(ns ui.views
  "fsm views
  Should not call `ui.functions` unless really necessary, e.g., in `r/create-class`"
  (:require
   [ui.actions :as a]
   [ui.db :as db]
   [ui.utils :as utils]
   [ui.http :as http]

   [reagent.core :as r]
   [taoensso.timbre :as t]
   [clojure.core.async :refer [go go-loop timeout <! >!]]
   [clojure.string :as s :refer [split-lines]]
   [cljs-uuid-utils.core :as uuid]
   [goog.object :as go])
  (:import
   [goog.string]
   [goog.dom]))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; views
(defn box []
  [:div.box.clickable
   {:on-click (fn [_]
                (swap! db/app-state update :clicked (fnil inc 0))
                (a/animate-to ".box" (assoc (a/box-next-position)
                                            :border-radius 50
                                            :duration      5)))}
   "A"])
