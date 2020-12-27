(ns ui.core
  (:require
   [ui.utils :as utils]
   [ui.views :as v]
   [ui.db :as db]
   [ui.actions :as a :refer [initer]]

   [taoensso.timbre :as t]
   [reagent.core :as r])
  (:import
   [goog.string]
   [goog.dom]))


(defn root-component []
  (fn []
    [:div.background
     [:h3 (str "You hit " (:clicked @db/app-state 0) " times")]
     [v/box]]))

(defn mount-components []
  (r/render
    [root-component]
    (js/document.getElementById "app-container")))


(enable-console-print!)

(defn ^:export main []
  @initer
  (mount-components))

(main)
