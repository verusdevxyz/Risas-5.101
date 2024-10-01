/*
 Copyright Alan Wood 2021
 None of this code to be reused without my written permission
 Intellectual Rights owned by Alan Wood
 */
package dev.risas.module.impl.render;

import dev.risas.module.Module;
import dev.risas.module.api.ModuleInfo;
import dev.risas.module.enums.Category;
import store.intent.intentguard.annotation.Exclude;
import store.intent.intentguard.annotation.Strategy;

@Exclude({Strategy.NUMBER_OBFUSCATION, Strategy.FLOW_OBFUSCATION})
@ModuleInfo(name = "NoHurtCam", description = "Removes the hurt camera when you get damaged", category = Category.RENDER)
public final class NoHurtCam extends Module {
}