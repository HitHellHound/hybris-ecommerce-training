/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesepaymentaddon.forms;

public class ChinesePaymentMethodForm
{
	private String code;

	private String name;

	private String logoUrl;

	/**
	 * @return the code
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * @param code
	 *           the code to set
	 */
	public void setCode(final String code)
	{
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *           the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the logoUrl
	 */
	public String getLogoUrl()
	{
		return logoUrl;
	}

	/**
	 * @param logoUrl
	 *           the logoUrl to set
	 */
	public void setLogoUrl(final String logoUrl)
	{
		this.logoUrl = logoUrl;
	}


}
