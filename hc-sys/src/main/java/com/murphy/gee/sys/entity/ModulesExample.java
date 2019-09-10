package com.murphy.gee.sys.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModulesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModulesExample() {
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

        public Criteria andModulesNameIsNull() {
            addCriterion("modules_name is null");
            return (Criteria) this;
        }

        public Criteria andModulesNameIsNotNull() {
            addCriterion("modules_name is not null");
            return (Criteria) this;
        }

        public Criteria andModulesNameEqualTo(String value) {
            addCriterion("modules_name =", value, "modulesName");
            return (Criteria) this;
        }

        public Criteria andModulesNameNotEqualTo(String value) {
            addCriterion("modules_name <>", value, "modulesName");
            return (Criteria) this;
        }

        public Criteria andModulesNameGreaterThan(String value) {
            addCriterion("modules_name >", value, "modulesName");
            return (Criteria) this;
        }

        public Criteria andModulesNameGreaterThanOrEqualTo(String value) {
            addCriterion("modules_name >=", value, "modulesName");
            return (Criteria) this;
        }

        public Criteria andModulesNameLessThan(String value) {
            addCriterion("modules_name <", value, "modulesName");
            return (Criteria) this;
        }

        public Criteria andModulesNameLessThanOrEqualTo(String value) {
            addCriterion("modules_name <=", value, "modulesName");
            return (Criteria) this;
        }

        public Criteria andModulesNameLike(String value) {
            addCriterion("modules_name like", value, "modulesName");
            return (Criteria) this;
        }

        public Criteria andModulesNameNotLike(String value) {
            addCriterion("modules_name not like", value, "modulesName");
            return (Criteria) this;
        }

        public Criteria andModulesNameIn(List<String> values) {
            addCriterion("modules_name in", values, "modulesName");
            return (Criteria) this;
        }

        public Criteria andModulesNameNotIn(List<String> values) {
            addCriterion("modules_name not in", values, "modulesName");
            return (Criteria) this;
        }

        public Criteria andModulesNameBetween(String value1, String value2) {
            addCriterion("modules_name between", value1, value2, "modulesName");
            return (Criteria) this;
        }

        public Criteria andModulesNameNotBetween(String value1, String value2) {
            addCriterion("modules_name not between", value1, value2, "modulesName");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkIsNull() {
            addCriterion("modules_remark is null");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkIsNotNull() {
            addCriterion("modules_remark is not null");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkEqualTo(String value) {
            addCriterion("modules_remark =", value, "modulesRemark");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkNotEqualTo(String value) {
            addCriterion("modules_remark <>", value, "modulesRemark");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkGreaterThan(String value) {
            addCriterion("modules_remark >", value, "modulesRemark");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("modules_remark >=", value, "modulesRemark");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkLessThan(String value) {
            addCriterion("modules_remark <", value, "modulesRemark");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkLessThanOrEqualTo(String value) {
            addCriterion("modules_remark <=", value, "modulesRemark");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkLike(String value) {
            addCriterion("modules_remark like", value, "modulesRemark");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkNotLike(String value) {
            addCriterion("modules_remark not like", value, "modulesRemark");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkIn(List<String> values) {
            addCriterion("modules_remark in", values, "modulesRemark");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkNotIn(List<String> values) {
            addCriterion("modules_remark not in", values, "modulesRemark");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkBetween(String value1, String value2) {
            addCriterion("modules_remark between", value1, value2, "modulesRemark");
            return (Criteria) this;
        }

        public Criteria andModulesRemarkNotBetween(String value1, String value2) {
            addCriterion("modules_remark not between", value1, value2, "modulesRemark");
            return (Criteria) this;
        }

        public Criteria andModulesOrderIsNull() {
            addCriterion("modules_order is null");
            return (Criteria) this;
        }

        public Criteria andModulesOrderIsNotNull() {
            addCriterion("modules_order is not null");
            return (Criteria) this;
        }

        public Criteria andModulesOrderEqualTo(Integer value) {
            addCriterion("modules_order =", value, "modulesOrder");
            return (Criteria) this;
        }

        public Criteria andModulesOrderNotEqualTo(Integer value) {
            addCriterion("modules_order <>", value, "modulesOrder");
            return (Criteria) this;
        }

        public Criteria andModulesOrderGreaterThan(Integer value) {
            addCriterion("modules_order >", value, "modulesOrder");
            return (Criteria) this;
        }

        public Criteria andModulesOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("modules_order >=", value, "modulesOrder");
            return (Criteria) this;
        }

        public Criteria andModulesOrderLessThan(Integer value) {
            addCriterion("modules_order <", value, "modulesOrder");
            return (Criteria) this;
        }

        public Criteria andModulesOrderLessThanOrEqualTo(Integer value) {
            addCriterion("modules_order <=", value, "modulesOrder");
            return (Criteria) this;
        }

        public Criteria andModulesOrderIn(List<Integer> values) {
            addCriterion("modules_order in", values, "modulesOrder");
            return (Criteria) this;
        }

        public Criteria andModulesOrderNotIn(List<Integer> values) {
            addCriterion("modules_order not in", values, "modulesOrder");
            return (Criteria) this;
        }

        public Criteria andModulesOrderBetween(Integer value1, Integer value2) {
            addCriterion("modules_order between", value1, value2, "modulesOrder");
            return (Criteria) this;
        }

        public Criteria andModulesOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("modules_order not between", value1, value2, "modulesOrder");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIsNull() {
            addCriterion("create_person is null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIsNotNull() {
            addCriterion("create_person is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonEqualTo(String value) {
            addCriterion("create_person =", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotEqualTo(String value) {
            addCriterion("create_person <>", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThan(String value) {
            addCriterion("create_person >", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThanOrEqualTo(String value) {
            addCriterion("create_person >=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThan(String value) {
            addCriterion("create_person <", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThanOrEqualTo(String value) {
            addCriterion("create_person <=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLike(String value) {
            addCriterion("create_person like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotLike(String value) {
            addCriterion("create_person not like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIn(List<String> values) {
            addCriterion("create_person in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotIn(List<String> values) {
            addCriterion("create_person not in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonBetween(String value1, String value2) {
            addCriterion("create_person between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotBetween(String value1, String value2) {
            addCriterion("create_person not between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andLastEditDateIsNull() {
            addCriterion("last_edit_date is null");
            return (Criteria) this;
        }

        public Criteria andLastEditDateIsNotNull() {
            addCriterion("last_edit_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastEditDateEqualTo(Date value) {
            addCriterion("last_edit_date =", value, "lastEditDate");
            return (Criteria) this;
        }

        public Criteria andLastEditDateNotEqualTo(Date value) {
            addCriterion("last_edit_date <>", value, "lastEditDate");
            return (Criteria) this;
        }

        public Criteria andLastEditDateGreaterThan(Date value) {
            addCriterion("last_edit_date >", value, "lastEditDate");
            return (Criteria) this;
        }

        public Criteria andLastEditDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_edit_date >=", value, "lastEditDate");
            return (Criteria) this;
        }

        public Criteria andLastEditDateLessThan(Date value) {
            addCriterion("last_edit_date <", value, "lastEditDate");
            return (Criteria) this;
        }

        public Criteria andLastEditDateLessThanOrEqualTo(Date value) {
            addCriterion("last_edit_date <=", value, "lastEditDate");
            return (Criteria) this;
        }

        public Criteria andLastEditDateIn(List<Date> values) {
            addCriterion("last_edit_date in", values, "lastEditDate");
            return (Criteria) this;
        }

        public Criteria andLastEditDateNotIn(List<Date> values) {
            addCriterion("last_edit_date not in", values, "lastEditDate");
            return (Criteria) this;
        }

        public Criteria andLastEditDateBetween(Date value1, Date value2) {
            addCriterion("last_edit_date between", value1, value2, "lastEditDate");
            return (Criteria) this;
        }

        public Criteria andLastEditDateNotBetween(Date value1, Date value2) {
            addCriterion("last_edit_date not between", value1, value2, "lastEditDate");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonIsNull() {
            addCriterion("last_edit_person is null");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonIsNotNull() {
            addCriterion("last_edit_person is not null");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonEqualTo(String value) {
            addCriterion("last_edit_person =", value, "lastEditPerson");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonNotEqualTo(String value) {
            addCriterion("last_edit_person <>", value, "lastEditPerson");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonGreaterThan(String value) {
            addCriterion("last_edit_person >", value, "lastEditPerson");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonGreaterThanOrEqualTo(String value) {
            addCriterion("last_edit_person >=", value, "lastEditPerson");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonLessThan(String value) {
            addCriterion("last_edit_person <", value, "lastEditPerson");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonLessThanOrEqualTo(String value) {
            addCriterion("last_edit_person <=", value, "lastEditPerson");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonLike(String value) {
            addCriterion("last_edit_person like", value, "lastEditPerson");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonNotLike(String value) {
            addCriterion("last_edit_person not like", value, "lastEditPerson");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonIn(List<String> values) {
            addCriterion("last_edit_person in", values, "lastEditPerson");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonNotIn(List<String> values) {
            addCriterion("last_edit_person not in", values, "lastEditPerson");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonBetween(String value1, String value2) {
            addCriterion("last_edit_person between", value1, value2, "lastEditPerson");
            return (Criteria) this;
        }

        public Criteria andLastEditPersonNotBetween(String value1, String value2) {
            addCriterion("last_edit_person not between", value1, value2, "lastEditPerson");
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