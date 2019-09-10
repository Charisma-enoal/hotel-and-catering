package com.murphy.gee.sys.entity;

import java.util.ArrayList;
import java.util.List;

public class AuthorityModulesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuthorityModulesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMappingIdIsNull() {
            addCriterion("mapping_id is null");
            return (Criteria) this;
        }

        public Criteria andMappingIdIsNotNull() {
            addCriterion("mapping_id is not null");
            return (Criteria) this;
        }

        public Criteria andMappingIdEqualTo(Long value) {
            addCriterion("mapping_id =", value, "mappingId");
            return (Criteria) this;
        }

        public Criteria andMappingIdNotEqualTo(Long value) {
            addCriterion("mapping_id <>", value, "mappingId");
            return (Criteria) this;
        }

        public Criteria andMappingIdGreaterThan(Long value) {
            addCriterion("mapping_id >", value, "mappingId");
            return (Criteria) this;
        }

        public Criteria andMappingIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mapping_id >=", value, "mappingId");
            return (Criteria) this;
        }

        public Criteria andMappingIdLessThan(Long value) {
            addCriterion("mapping_id <", value, "mappingId");
            return (Criteria) this;
        }

        public Criteria andMappingIdLessThanOrEqualTo(Long value) {
            addCriterion("mapping_id <=", value, "mappingId");
            return (Criteria) this;
        }

        public Criteria andMappingIdIn(List<Long> values) {
            addCriterion("mapping_id in", values, "mappingId");
            return (Criteria) this;
        }

        public Criteria andMappingIdNotIn(List<Long> values) {
            addCriterion("mapping_id not in", values, "mappingId");
            return (Criteria) this;
        }

        public Criteria andMappingIdBetween(Long value1, Long value2) {
            addCriterion("mapping_id between", value1, value2, "mappingId");
            return (Criteria) this;
        }

        public Criteria andMappingIdNotBetween(Long value1, Long value2) {
            addCriterion("mapping_id not between", value1, value2, "mappingId");
            return (Criteria) this;
        }

        public Criteria andModulesIdIsNull() {
            addCriterion("modules_id is null");
            return (Criteria) this;
        }

        public Criteria andModulesIdIsNotNull() {
            addCriterion("modules_id is not null");
            return (Criteria) this;
        }

        public Criteria andModulesIdEqualTo(Long value) {
            addCriterion("modules_id =", value, "modulesId");
            return (Criteria) this;
        }

        public Criteria andModulesIdNotEqualTo(Long value) {
            addCriterion("modules_id <>", value, "modulesId");
            return (Criteria) this;
        }

        public Criteria andModulesIdGreaterThan(Long value) {
            addCriterion("modules_id >", value, "modulesId");
            return (Criteria) this;
        }

        public Criteria andModulesIdGreaterThanOrEqualTo(Long value) {
            addCriterion("modules_id >=", value, "modulesId");
            return (Criteria) this;
        }

        public Criteria andModulesIdLessThan(Long value) {
            addCriterion("modules_id <", value, "modulesId");
            return (Criteria) this;
        }

        public Criteria andModulesIdLessThanOrEqualTo(Long value) {
            addCriterion("modules_id <=", value, "modulesId");
            return (Criteria) this;
        }

        public Criteria andModulesIdIn(List<Long> values) {
            addCriterion("modules_id in", values, "modulesId");
            return (Criteria) this;
        }

        public Criteria andModulesIdNotIn(List<Long> values) {
            addCriterion("modules_id not in", values, "modulesId");
            return (Criteria) this;
        }

        public Criteria andModulesIdBetween(Long value1, Long value2) {
            addCriterion("modules_id between", value1, value2, "modulesId");
            return (Criteria) this;
        }

        public Criteria andModulesIdNotBetween(Long value1, Long value2) {
            addCriterion("modules_id not between", value1, value2, "modulesId");
            return (Criteria) this;
        }

        public Criteria andAuthIdIsNull() {
            addCriterion("auth_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthIdIsNotNull() {
            addCriterion("auth_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthIdEqualTo(Long value) {
            addCriterion("auth_id =", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotEqualTo(Long value) {
            addCriterion("auth_id <>", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThan(Long value) {
            addCriterion("auth_id >", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThanOrEqualTo(Long value) {
            addCriterion("auth_id >=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThan(Long value) {
            addCriterion("auth_id <", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThanOrEqualTo(Long value) {
            addCriterion("auth_id <=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdIn(List<Long> values) {
            addCriterion("auth_id in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotIn(List<Long> values) {
            addCriterion("auth_id not in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdBetween(Long value1, Long value2) {
            addCriterion("auth_id between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotBetween(Long value1, Long value2) {
            addCriterion("auth_id not between", value1, value2, "authId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}