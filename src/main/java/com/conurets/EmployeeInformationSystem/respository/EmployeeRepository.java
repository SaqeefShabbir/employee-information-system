package com.conurets.EmployeeInformationSystem.respository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Qualifier("employees")
@Repository
public class EmployeeRepository {

//    @Override
//    public List<EmployeeDAO> findAllDTOsForDataTable(List<OrderByDTO> orderByDTOs, int start, int length, String searchTerm) throws TextileException
//    {
//        try
//        {
//            TypedQuery<EmployeeDAO> query = createQueryOrderByAndSearchTerm(orderByDTOs, searchTerm);
//            query.setFirstResult(start);
//            query.setMaxResults(length);
//            return query.getResultList();
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public TypedQuery<EmployeeDAO> findAllDAOsBySearchCriteria(SearchCriteriaDTO searchCriteriaDTO, int pageNumber, int pageSize) throws TextileException {
//        try
//        {
//            CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
//            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
//            Root<EmployeeDAO> root = criteriaQuery.from(EmployeeDAO.class);
//
//            List<Predicate> predicates = new ArrayList<>();
//
//            if (Objects.nonNull(searchCriteriaDTO))
//            {
//                if (AppUtil.isNumberGreaterThanZero(searchCriteriaDTO.getEmployeeId()))
//                {
//                    predicates.add(criteriaBuilder.equal(root.get("id"), searchCriteriaDTO.getEmployeeId()));
//                }
//
//                if (StringUtils.hasText(searchCriteriaDTO.getTimeMachineId()))
//                {
//                    predicates.add(criteriaBuilder.equal(root.get("timeMachineId"), searchCriteriaDTO.getTimeMachineId()));
//                }
//
//                if (Objects.nonNull(searchCriteriaDTO.getEmployeeStatusId()))
//                {
//                    predicates.add(criteriaBuilder.equal(root.get("employeeStatus"), searchCriteriaDTO.getEmployeeStatusId()));
//                }
//
//                if (StringUtils.hasText(searchCriteriaDTO.getPayrollMonthYearStr()))
//                {
//                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                    String receiveDate = searchCriteriaDTO.getPayrollMonthYearStr().concat("-01");
//                    Date firstDayOfMonth = formatter.parse(receiveDate);
//                    Calendar calendar = Calendar.getInstance();
//                    calendar.setTime(firstDayOfMonth);
//
//                    calendar.add(Calendar.MONTH, 1);
//                    calendar.set(Calendar.DAY_OF_MONTH, 1);
//                    calendar.add(Calendar.DATE, -1);
//
//                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("joiningDate"), calendar.getTime()));
//                }
//
//                if (StringUtils.hasText((searchCriteriaDTO.getFirstName())))
//                {
//                    predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + searchCriteriaDTO.getFirstName() + "%"));
//                }
//
//                if (StringUtils.hasText((searchCriteriaDTO.getLastName())))
//                {
//                    predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + searchCriteriaDTO.getLastName() + "%"));
//                }
//
//                if (Objects.nonNull(searchCriteriaDTO.getDateOfBirth()))
//                {
//                    predicates.add(criteriaBuilder.equal(root.get("DOB"), searchCriteriaDTO.getDateOfBirth()));
//                }
//
//                if (Objects.nonNull(searchCriteriaDTO.getJoiningDate()))
//                {
//                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("joiningDate"), searchCriteriaDTO.getJoiningDate()));
//                }
//
//                if (AppUtil.isNumberGreaterThanZero(searchCriteriaDTO.getShiftId()))
//                {
//                    Join join = root.join("shiftDAO");
//                    predicates.add(criteriaBuilder.equal(join.get("id"), searchCriteriaDTO.getShiftId()));
//                }
//
//                if (AppUtil.isNumberGreaterThanZero(searchCriteriaDTO.getDepartmentId()))
//                {
//                    Join join = root.join("departmentDAO");
//                    predicates.add(criteriaBuilder.equal(join.get("id"), searchCriteriaDTO.getDepartmentId()));
//                }
//
//                if (Objects.nonNull(searchCriteriaDTO.getMaritalStatusId()))
//                {
//                    predicates.add(criteriaBuilder.equal(root.get("maritalStatus"), searchCriteriaDTO.getMaritalStatusId()));
//                }
//
//                if (Objects.nonNull(searchCriteriaDTO.getDesignationId()))
//                {
//                    Join join = root.join("designationDAO");
//                    predicates.add(criteriaBuilder.equal(join.get("id"), searchCriteriaDTO.getDesignationId()));
//                }
//
//                if (Objects.nonNull(searchCriteriaDTO.getReportingToId()))
//                {
//                    predicates.add(criteriaBuilder.equal(root.get("managerDAO"), searchCriteriaDTO.getReportingToId()));
//                }
//
//                if (Objects.nonNull(searchCriteriaDTO.getEmpTypeId())) {
//                    Join employeeTypeLookupTypeValueDaoJoin = root.join("employeeType");
//                    predicates.add(criteriaBuilder.equal(employeeTypeLookupTypeValueDaoJoin.get("id"), searchCriteriaDTO.getEmpTypeId()));
//                }
//
//                if (Objects.nonNull(searchCriteriaDTO.getEmpStatusId())) {
//                    Join employeeStatusLookupTypeValueDaoJoin = root.join("employeeStatus");
//                    predicates.add(criteriaBuilder.equal(employeeStatusLookupTypeValueDaoJoin.get("id"), searchCriteriaDTO.getEmpStatusId()));
//                }
//
//                if (Objects.nonNull(searchCriteriaDTO.getOverTimeApp()))
//                {
//                    predicates.add(criteriaBuilder.equal(root.get("overtimeApplicable"), searchCriteriaDTO.getOverTimeApp()));
//                }
//
//                if (Objects.nonNull(searchCriteriaDTO.getDayOffSixDays()))
//                {
//                    predicates.add(criteriaBuilder.equal(root.get("dayOffOnSixDays"), searchCriteriaDTO.getDayOffSixDays()));
//                }
//
//                if (Objects.nonNull(searchCriteriaDTO.getHod()))
//                {
//                    predicates.add(criteriaBuilder.equal(root.get("hod"), searchCriteriaDTO.getHod()));
//                }
//            }
//            criteriaQuery.select(root).where(predicates.toArray(new Predicate[]{}));
//
//            List<Order> orderByList = new ArrayList<>();
//            orderByList.add(criteriaBuilder.asc(root.get("id")));
//
//            criteriaQuery.orderBy(orderByList);
//
//            return getSession().createQuery(criteriaQuery);
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        return null;
//    }
}
