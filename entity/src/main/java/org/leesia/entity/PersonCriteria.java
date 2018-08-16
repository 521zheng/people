package org.leesia.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("BIRTHDAY =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("BIRTHDAY <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("BIRTHDAY >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("BIRTHDAY >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("BIRTHDAY <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("BIRTHDAY <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("BIRTHDAY like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("BIRTHDAY not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("BIRTHDAY in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("BIRTHDAY not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("BIRTHDAY between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("BIRTHDAY not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("NATION is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("NATION is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("NATION =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("NATION <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("NATION >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("NATION >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("NATION <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("NATION <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("NATION like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("NATION not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("NATION in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("NATION not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("NATION between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("NATION not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceIsNull() {
            addCriterion("REGISTER_PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceIsNotNull() {
            addCriterion("REGISTER_PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceEqualTo(String value) {
            addCriterion("REGISTER_PROVINCE =", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceNotEqualTo(String value) {
            addCriterion("REGISTER_PROVINCE <>", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceGreaterThan(String value) {
            addCriterion("REGISTER_PROVINCE >", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTER_PROVINCE >=", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceLessThan(String value) {
            addCriterion("REGISTER_PROVINCE <", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceLessThanOrEqualTo(String value) {
            addCriterion("REGISTER_PROVINCE <=", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceLike(String value) {
            addCriterion("REGISTER_PROVINCE like", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceNotLike(String value) {
            addCriterion("REGISTER_PROVINCE not like", value, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceIn(List<String> values) {
            addCriterion("REGISTER_PROVINCE in", values, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceNotIn(List<String> values) {
            addCriterion("REGISTER_PROVINCE not in", values, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceBetween(String value1, String value2) {
            addCriterion("REGISTER_PROVINCE between", value1, value2, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterProvinceNotBetween(String value1, String value2) {
            addCriterion("REGISTER_PROVINCE not between", value1, value2, "registerProvince");
            return (Criteria) this;
        }

        public Criteria andRegisterCityIsNull() {
            addCriterion("REGISTER_CITY is null");
            return (Criteria) this;
        }

        public Criteria andRegisterCityIsNotNull() {
            addCriterion("REGISTER_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterCityEqualTo(String value) {
            addCriterion("REGISTER_CITY =", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityNotEqualTo(String value) {
            addCriterion("REGISTER_CITY <>", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityGreaterThan(String value) {
            addCriterion("REGISTER_CITY >", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTER_CITY >=", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityLessThan(String value) {
            addCriterion("REGISTER_CITY <", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityLessThanOrEqualTo(String value) {
            addCriterion("REGISTER_CITY <=", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityLike(String value) {
            addCriterion("REGISTER_CITY like", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityNotLike(String value) {
            addCriterion("REGISTER_CITY not like", value, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityIn(List<String> values) {
            addCriterion("REGISTER_CITY in", values, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityNotIn(List<String> values) {
            addCriterion("REGISTER_CITY not in", values, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityBetween(String value1, String value2) {
            addCriterion("REGISTER_CITY between", value1, value2, "registerCity");
            return (Criteria) this;
        }

        public Criteria andRegisterCityNotBetween(String value1, String value2) {
            addCriterion("REGISTER_CITY not between", value1, value2, "registerCity");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceIsNull() {
            addCriterion("LIVE_PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceIsNotNull() {
            addCriterion("LIVE_PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceEqualTo(String value) {
            addCriterion("LIVE_PROVINCE =", value, "liveProvince");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceNotEqualTo(String value) {
            addCriterion("LIVE_PROVINCE <>", value, "liveProvince");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceGreaterThan(String value) {
            addCriterion("LIVE_PROVINCE >", value, "liveProvince");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("LIVE_PROVINCE >=", value, "liveProvince");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceLessThan(String value) {
            addCriterion("LIVE_PROVINCE <", value, "liveProvince");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceLessThanOrEqualTo(String value) {
            addCriterion("LIVE_PROVINCE <=", value, "liveProvince");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceLike(String value) {
            addCriterion("LIVE_PROVINCE like", value, "liveProvince");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceNotLike(String value) {
            addCriterion("LIVE_PROVINCE not like", value, "liveProvince");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceIn(List<String> values) {
            addCriterion("LIVE_PROVINCE in", values, "liveProvince");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceNotIn(List<String> values) {
            addCriterion("LIVE_PROVINCE not in", values, "liveProvince");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceBetween(String value1, String value2) {
            addCriterion("LIVE_PROVINCE between", value1, value2, "liveProvince");
            return (Criteria) this;
        }

        public Criteria andLiveProvinceNotBetween(String value1, String value2) {
            addCriterion("LIVE_PROVINCE not between", value1, value2, "liveProvince");
            return (Criteria) this;
        }

        public Criteria andLiveCityIsNull() {
            addCriterion("LIVE_CITY is null");
            return (Criteria) this;
        }

        public Criteria andLiveCityIsNotNull() {
            addCriterion("LIVE_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andLiveCityEqualTo(String value) {
            addCriterion("LIVE_CITY =", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityNotEqualTo(String value) {
            addCriterion("LIVE_CITY <>", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityGreaterThan(String value) {
            addCriterion("LIVE_CITY >", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityGreaterThanOrEqualTo(String value) {
            addCriterion("LIVE_CITY >=", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityLessThan(String value) {
            addCriterion("LIVE_CITY <", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityLessThanOrEqualTo(String value) {
            addCriterion("LIVE_CITY <=", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityLike(String value) {
            addCriterion("LIVE_CITY like", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityNotLike(String value) {
            addCriterion("LIVE_CITY not like", value, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityIn(List<String> values) {
            addCriterion("LIVE_CITY in", values, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityNotIn(List<String> values) {
            addCriterion("LIVE_CITY not in", values, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityBetween(String value1, String value2) {
            addCriterion("LIVE_CITY between", value1, value2, "liveCity");
            return (Criteria) this;
        }

        public Criteria andLiveCityNotBetween(String value1, String value2) {
            addCriterion("LIVE_CITY not between", value1, value2, "liveCity");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNull() {
            addCriterion("CREATE_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNotNull() {
            addCriterion("CREATE_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeEqualTo(Date value) {
            addCriterion("CREATE_DATETIME =", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotEqualTo(Date value) {
            addCriterion("CREATE_DATETIME <>", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThan(Date value) {
            addCriterion("CREATE_DATETIME >", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATETIME >=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThan(Date value) {
            addCriterion("CREATE_DATETIME <", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATETIME <=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIn(List<Date> values) {
            addCriterion("CREATE_DATETIME in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotIn(List<Date> values) {
            addCriterion("CREATE_DATETIME not in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATETIME between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATETIME not between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNull() {
            addCriterion("UPDATE_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNotNull() {
            addCriterion("UPDATE_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME =", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME <>", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThan(Date value) {
            addCriterion("UPDATE_DATETIME >", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME >=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThan(Date value) {
            addCriterion("UPDATE_DATETIME <", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME <=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIn(List<Date> values) {
            addCriterion("UPDATE_DATETIME in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotIn(List<Date> values) {
            addCriterion("UPDATE_DATETIME not in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATETIME between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATETIME not between", value1, value2, "updateDatetime");
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