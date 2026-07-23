(ns marketentry.facts "Finland market-entry catalog.")
(def catalog
  {"FIN" {:name "Finland"
          :owner-authority "Hansel / Hilma"
          :legal-basis "Hankintalaki; EU directives"
          :national-spec "Hilma / e-procurement + Y-tunnus"
          :provenance "https://www.hankintailmoitukset.fi/"
          :required-evidence ["Y-tunnus record"
                              "Hilma/e-procurement registration record"
                              "PRH extract"
                              "Authorized-representative record"]
          :rep-owner-authority "contracting authorities / Hansel"
          :rep-legal-basis "EU establishment or Finnish business ID for many procedures"
          :rep-provenance "https://www.hankintailmoitukset.fi/"
          :corporate-number-owner-authority "PRH / Tax Administration"
          :corporate-number-legal-basis "Y-tunnus (business ID)"
          :corporate-number-provenance "https://www.prh.fi/"}})

(defn spec-basis [iso3] (get catalog iso3))
(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note "R0 catalog seed"})))
(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))
(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))
(defn rep-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))
(defn corporate-number-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority :corporate-number-legal-basis :corporate-number-provenance]))))
