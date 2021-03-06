package com.intellij.aws.cloudformation.metadata

import com.intellij.aws.cloudformation.model.CfnRootNode

data class CloudFormationMetadata(
    val resourceTypes: Map<String, CloudFormationResourceType>,
    val predefinedParameters: List<String>,
    val limits: CloudFormationLimits) {

  fun findResourceType(name: String, context: CfnRootNode): CloudFormationResourceType? {
    val resourceType = resourceTypes[name]
    if (resourceType?.transform != null && resourceType.transform != context.transformStringValue) {
      return null
    }

    return resourceType
  }
}
