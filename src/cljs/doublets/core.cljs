(ns doublets.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [ajax.core :refer [GET]]))

(defonce app-state (atom {:text "Doublets solver"
                          :random-word "Foo"}))

(defn main []
  (om/root
    (fn [app owner]
      (reify
        om/IRender
        (render [_]
          (dom/h1 nil (:text app)))))
    app-state
    {:target (. js/document (getElementById "app"))}))

(GET "/cromulent-words" {:handler (fn [response] (.log js/console (str response)))})
