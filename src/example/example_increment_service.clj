(ns example.example-increment-service
  (:require [puppetlabs.trapperkeeper.core :as trapperkeeper]
            [clojure.tools.logging :as log]
            [example.example-core :as core]))


(defprotocol IncrementService
  (increment [this number])
  )

(trapperkeeper/defservice increment-service
  IncrementService
  []
  (init [this context]
        (log/info "Initialize increment service")
        context)

  (start [this context]
         (log/info "Start increment service")
         context)

  (stop [this context]
        (log/info "Stop increment service")
        context)
  (increment [this number]
         (core/incrementer number))
  )