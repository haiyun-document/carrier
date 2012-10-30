(ns carrier.web
  (:use compojure.core
        [hiccup.middleware :only (wrap-base-url)])
  (:require [carrier.core :as api]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]))

(defroutes main-routes
  
  (GET "/" [] "Carrier API")

  (GET "/inbox" {params :params}
    (apply api/inbox ((juxt :email :password) params)))
  
  (route/not-found "Page not found"))

(def app
  (-> (handler/site main-routes)
      (wrap-base-url)))

(defn -main
  [& args])
