(ns example.example-increment-controller
  (:require [compojure.core :as compojure]
            [clojure.tools.logging :as log]
            [example.example-increment-service :as increment-service]))


(defn increment_controller
  [service-context]

  (compojure/routes
    (compojure/GET "/:number" [number]
      (fn [req]
        (log/info "Handle increment number request")
        {:status 200
         :headers {"Content-Type" "text/plain"}
         :body (increment-service/increment service-context number)
         }
        )
      )
    )
  )
